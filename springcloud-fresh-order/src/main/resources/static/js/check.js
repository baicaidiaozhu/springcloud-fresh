let login_info = new Vue({
	el : "#login_info",
	data:{
		nickName:'',
		goodsCount:0,
		loginId:"",
		carts:{},
	},
	mounted:function(){ //数据加载之前相当于jquery中的$(function(){})
		axios.get("/view/member/check",{params:{}}).then(result=>{ //function(result){}
			if(result.data.code == 200){
				this.nickName = result.data.data.member.nickName;
				this.loginId = result.data.data.member.mno;
				if(result.data.data.carts){
					this.carts=result.data.data.carts;
					this.goodsCount = result.data.data.carts.length;
				}
			}else{
				this.nickName == '';
				alert("请先登录");
				location.href="/user/login.html";
			}
		})
	}
})

