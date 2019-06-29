// MP3播放器及歌曲库js


var myPlaylist = new jPlayerPlaylist({
        jPlayer: "#jquery_jplayer_N",
        cssSelectorAncestor: "#jp_container_N"
    },
    [
        {
            title: "Ellens Gesang III D839",
            artist: "Geoffrey Parsons",
            mp3: "http://music.163.com/song/media/outer/url?id=16691428.mp3  ",
            poster: "http://p1.music.126.net/wAIlwR4SxuZg_ZMwgmSYcg==/3386495814257726.jpg?param=130y130"
        },
        {
            title: "默",
            artist: "那英",
            mp3: "http://music.163.com/song/media/outer/url?id=31473269.mp3 ",
            poster: "http://p1.music.126.net/OCGt5ln0lPPtPbVJ3VEKtA==/109951163020570422.jpg?param=130y130"
        },
        {
            title: "Fire",
            artist: "Said The Sky",
            mp3: "http://music.163.com/song/media/outer/url?id=435289279.mp3",
            poster: "http://p1.music.126.net/tg2zke_mrqwuOPlEIEUjGg==/18294773975127592.jpg?param=130y130"
        }
    ],

    {
        playlistOptions: {enableRemoveControls: true},
        swfPath: "js/",
        supplied: "webmv, ogv, m4v, oga, mp3",
        useStateClassSkin: true,
        autoBlur: false,
        smoothPlayBar: true,
        keyEnabled: true,
        audioFullScreen: true
    });

var vm = new Vue({
    el: "#app",
    data: {
        user: {
            name: ''
        },
        currentPage: 1,
        songLists: [],
        songs: []
    },
    created: function () {
        axios.get('http://localhost:8080/musicManage/getSongsByPages?pages=1')
            .then(function (response) {
                console.log(response);
                var songMessage = response.data.detail.songs;
                for (var i = 0; i < songMessage.length; i++) {
                    var data = {name: songMessage[i].name, artist: "", url: songMessage[i].url}
                    vm.songs.push(data);
                }
                console.log(latest)
            })
            .catch(function (error) {
                console.log(error);
            });

        axios.get('http://localhost:8080/songList')
            .then(function (response) {
                console.log(response);
                vm.songLists  = response.data.detail.songLists;
                console.log(vm.songLists);
            })
            .catch(function (error) {
                console.log(error);
            });
    },
    methods: {
        playMusic: function (obj) {
            myPlaylist.add({
                title: obj.name, artist: "在线音乐平台开发小组",
                //free:true,
                mp3: obj.url,
                //oga:"",
                poster: "data:image/jpeg;base64,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"
            });
            myPlaylist.play(-1);
        },
        songListMessage: function (obj) {
            window.location.href="songList.html?id=" + obj.id;
        }
    }
});

var sl = new Vue({
    el:"#app2",
    data: {
        songLists: [],
        cur: 1,
        all: 8,
        limit:2,
        url: ''
    },
    components:{
        'vue-nav': Vnav
    },
    methods: {
        callback: function(data){
            this.cur = data;
        }
    },
    created: function(){
        axios.get('http://localhost:8080/songList')
            .then(function (response) {
                console.log(response);
                sl.songLists  = response.data.detail.songLists;
                sl.all = Math.ceil(sl.songLists.length / sl.limit);
                console.log(sl.songLists);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
});

var log = new Vue({
    el:'#login',
    template:'',
    data: {
        nickname:'',
        password:''
    },
    methods: {
        submit: function() {
            axios.post('http://localhost:8080/login', {
                nickname: this.nickname,   // 用户名
                password: this.password    // 密码
            })
                .then(function (response) {
                    console.log(response);
                    alert("登陆成功");
                })
                .catch(function (error) {
                    console.log(error);
                    alert("登陆失败");
                });
        }
    }
});

var reg = new Vue({
    el:'#register',
    template:'',
    data: {
        nickname:'',
        password:''
    },
    methods: {
        submit: function() {
            axios.post('http://localhost:8080/register', {
                nickname: this.nickname,   // 用户名
                password: this.password    // 密码
            })
                .then(function (response) {
                    console.log(response);
                    alert("登陆成功");
                })
                .catch(function (error) {
                    console.log(error);
                    alert("登陆失败");
                });
        }
    }
});

	
	
	
	
	
	
	
	
	
	
