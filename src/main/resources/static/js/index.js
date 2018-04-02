var vm = new Vue({
                el: '#app',
                data: {
                    // 两个button的下拉列表
                    datas: [],
                    interpretable: [],
                    // 两个button
                    message:'选择语言',
                    interpretablemessage:'选择翻译语言',
                    // 两个选中语言的缩写
                    source:'',
                    translate:'',
                    // 两个文本框中数据
                    translatesource:'',
                    translator:'',
                    // 音频路径
                    path:'',
                    //文本框行数
                    textrows : 4,
                    //状态参数
                    statue : 0,
                    toSpeechstatue : 0
                },
                methods:{
                    //进入页面运行提供初始化数据
                    api: function() {
                        var http = new XMLHttpRequest();
                        http.open('get', 'https://translater.au-syd.mybluemix.net/init', true);
                        var that = this; 
                        http.onreadystatechange = function() {
                            if (http.readyState === 4 && http.status === 200) {
                                that.datas = JSON.parse(http.responseText);
                            }
                        };
                        http.send();
                    },
                    //翻译文本框中内容
                    api2: function() {
                        var timer1=window.setTimeout(function(){},400);  //timer1->1 当前是第一个定时器
                        if(this.translatesource === ''){
                            this.translator = "";
                            return;
                        }

                        if(this.translatesource ===""){
                            this.translator = '';
                            return;
                        }
                        var http = new XMLHttpRequest();
                        this.statue++;
                        http.open('get','https://translater.au-syd.mybluemix.net/translate?source='+this.source+'&translate='+this.translate+'&message='+this.translatesource+'&statue='+this.statue,true);
                        var that = this;
                        http.onreadystatechange = function() {
                            if(http.readyState === 4 && http.status ===200 && JSON.parse(http.responseText).statue == that.statue){
                                that.translator = JSON.parse(http.responseText).translateresult;
                            }
                        };
                        http.send();
                    },
                    //生成语音
                    api3: function() {
                        if(this.translatesource != '' && this.translator !=""){
                            var http = new XMLHttpRequest();
                            this.toSpeechstatue++;
                            http.open('get',"https://translater.au-syd.mybluemix.net/toSpeech?translate="+this.translate+"&translator="+this.translator+"&toSpeechstatue="+this.toSpeechstatue,true);
                            var that = this;
                            http.onreadystatechange = function() {
                                if(http.readyState === 4 && http.status === 200 && JSON.parse(http.responseText).toSpeechstatue == that.toSpeechstatue){
                                    that.path = JSON.parse(http.responseText).path;
                                    document.getElementById("play").style.visibility = 'visible';
                                }
                            };
                            http.send();
                        }
                    }
                },
                created: function() {
                    this.api();
                },
                watch:{
                    message: function(curVal, oldVal) {
                        var a = this.datas;
                        this.translatesource = '';
                        this.translator = '';
                        this.interpretablemessage = '';

                        for(var i=0;i<a.length;i++){
                            if(a[i].fullName === curVal){
                                this.interpretable = a[i].interpretable;
                            }
                        }
                        if(this.interpretable.length === 1){
                            this.interpretablemessage = this.interpretable[0].versionFullName;
                            this.translate = this.interpretable[0].versionShortName;
                        }
                        else
                            this.interpretablemessage = "请选择翻译语言";
                    },
                    translatesource: function(curVal, oldVal) {
                        if(this.translatesource === ''){
                            document.getElementById("play").style.visibility = 'hidden';                           
                            this.translator = '';
                        }
                        if(this.source !=''&& this.translate != '' && this.translatesource != ''){
                            document.getElementById("play").style.visibility = 'hidden';
                            var timer1=window.setTimeout(this.api2(),400);
                        }
                    },
                    interpretablemessage: function(curVal, oldVal) {
                        if(this.translatesource === ''){
                            document.getElementById("play").style.visibility = 'hidden';
                            this.translator = '';
                        }
                        if(this.source!=''&& this.translate != '' && this.translatesource != ''){
                            document.getElementById("play").style.visibility = 'hidden';
                            this.api2();
                        }
                    },
                    translator: function(curVal, oldVal){
                        if(this.translator != ''){
                           this.api3();
                        }
                        var tex = document.getElementById("translatetext");
                        tex.rows = this.textrows;
                    }
                }
            })
            //选择语言的两个按钮
            function check(id){
                vm.message = document.getElementById(id).innerText;
                vm.source = id;
            }
            function checktranslate(id){
                vm.interpretablemessage = document.getElementById(id).innerText;
                vm.translate = id;
            }
            //音频播放按钮
            var isPlaying = false;
            function play(){
                var player = document.querySelector('#test');
                if (isPlaying) {
                    isPlaying = false;
                    player.pause();
                } else {
                    player.src = vm.path;
                    player.play();
                    isPlaying = true;
                }

            }
            //文本框清空
            var row = 4; 
            $("#clean").click(function (){ 
                vm.translatesource = '';
                vm.translator = '';
                row=4;
                var tes = document.getElementById("text");
                tes.rows=row;
            }) 
            //监听文本框，自适应高度
            text.addEventListener('input', function(e) {
                var te = document.getElementById("text");
                if(text.scrollHeight>140){
                    row = te.value.split(/\n/).length
                    var rowcount = te.value.split(/\n/);
                    for(var i = 0;i<rowcount.length;i++)
                    {
                        if(rowcount[i].length/te.cols===1 && rowcount[i].length%te.cols){
                            row++;
                        }
                        if(rowcount[i].length/te.cols>1){
                            row = row + rowcount[i].length/te.cols;
                        }
                    }
                    te.rows=parseInt(row);
                    vm.textrows = te.rows;
                }
            });