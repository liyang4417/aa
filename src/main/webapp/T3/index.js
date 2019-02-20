$(document).ready(function(){
	init();
})

/**
 * 初始化
 * 	开始飞出形成一圈的效果
 */
function init(){
	var oImg = $('img'); 	//获取所有img标签
	var len = oImg.length;  //获取图片标签数量
	var deg = 360/len; 	//获取每张图片的平均角度
	
	//展出
	for(var i = 0 ; i < len; i++){
		//给每一张图片设置样式
		$(oImg[i]).css({
		    //设置移动效果    先旋转(平均角度*i)    在往Z轴方向平移，达到一圈的效果
			transform:'rotateY('+ deg*i +'deg) translateZ(300px)',
			//设置过度效果
			transition:'transform 1s ' + (len - 1 - i)*0.1 + 's'
		})
	}
	bindEvent();
}


function bindEvent(){
	var box = $('#box'); //基准
	var body = $('body'); //获取body标签
	var lastX,lastY,nowX,nowY;
	var disX = 0,disY = 0; //计算坐标差值
	var roY = 0, roX = -21; //旋转位置
	var timer;
	
	body.on('mousedown',function(e){//鼠标按下事件

		lastX = e.clientX; //获取当前鼠标位置
		lastY = e.clientY; 
		
		body.on('mousemove',function(e){//鼠标移动事件
			nowX = e.clientX; //在次获取鼠标的位置
			nowY = e.clientY; 
			//计算坐标差值
			disX = nowX - lastX;
			disY = nowY - lastY;
			//进行box旋转
			roY += disX*0.1;
			roX -= disY*0.1;

			box.css({
				transform:'rotateY(' + roY + 'deg) rotateX(' + roX + 'deg)',
				cursor: 'pointer'
			})
			
			lastX = nowX;
			lastY = nowY;
		});
		
		body.on('mouseup',function(){//鼠标抬起事件
			body.off('mousemove') //解除事件
			clearInterval(timer);//清除计时器
			//延迟的感觉
			timer = setInterval(function(){
				disX *= 0.98;
				disY *= 0.98;
				
				//进行box旋转
				roY += disX*0.1;
				roX -= disY*0;
				box.css({
					transform:'rotateY(' + roY + 'deg) rotateX(' + roX + 'deg)',
					cursor: 'pointer'
				})
				console.log(roY);
				if(Math.abs(disX) < 0.1 && Math.abs(disY) < 0.1){
					clearInterval(timer);//清除计时器
				}
			},20)
			
		});
		return false; //取消默认事件
	})
	
}
