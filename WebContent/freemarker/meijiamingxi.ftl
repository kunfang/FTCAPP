<html lang="zh-CN">
<head>
<#import "header.ftl" as head> 
<@head.header title="产品"/>
</head>
<body style="background-color:#CCC">
<img src="${prod.fileUrl}" style="width:100%;">
<div class="container" style="background-color:#FFF">
	<div class="row" style="margin-bottom:20px;">
    	<div class="col-xs-4 col-md-6">
        	<span class="price">
            	<span class="price-num">¥${prod.price}</span>
            </span>
        </div>
        <div class="col-xs-8 col-md-6 text-right">
        	<span class="total-sale">${prod.totalNum}人做过</span>
        </div>
    </div>
    <div class="row" style="margin-bottom:20px;">
    	<div class="col-xs-12 col-md-12">
        	<span>店面价:</span>
            <span><del>¥${prod.storePrice}</del></span>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-md-12">
        	<p>${prod.comments}</p>
            <hr>
        </div>
    </div>
    <div class="row"  style="margin-bottom:20px;">
    	<div class="col-xs-6 col-md-6">
        	<span>耗时：${prod.timeConsume}分钟</span>
        </div>
        <div class="col-xs-6 col-md-6">
        	<span>保持：${prod.timeKeep}天</span>
        </div>
    </div>
</div>
<div style="height:5px"></div>	
<div class="container" style="background-color:#FFF">
	<div class="row" style="margin-top:20px;">
    	<div class="col-xs-4 col-md-4">
        	<span><img src="images/icon_service_time.png" style="max-height:18px;max-width:12px"></span>
        	<span>预约时间</span>
        </div>
        <div class="col-xs-8 col-md-8 text-right"><span><img src="images/right_arrow_small.png" style="max-width:12px"></span></div>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-md-12"><hr></div>
    </div>
    <div class="row" style="margin-bottom:20px;">
    	<div class="col-xs-4 col-md-4">
        	<span><img src="images/icon_service_address.png" style="max-height:18px"></span>
        	<span>服务地址</span>
        </div>
        <div class="col-xs-8 col-md-8 text-right"><span>中山西路1279弄6号5楼</span><span style="padding-left:5px;"><img src="images/right_arrow_small.png" style="max-width:12px;"></span></div>
    </div>
</div>
<div style="height:5px"></div>
<div class="container" style="background-color:#FFF">
	<div class="row">
    	<div class="col-xs-4 col-md-4 text-center"><img src="images/1.jpg" alt="..." class="img-circle" style="width:100%;"></div>
        <div class="col-xs-8 col-md-8">
        	<div class="row" style="height:100%">
            	<div class="col-xs-12 col-md-12"><span><h5>小美</h5></span></div>
            </div>
            <div class="row">
            	<div class="col-xs-9 col-md-9"><img src="images/rating_diamond.png" style="max-height:18px"></div>
                <div class="col-xs-3 col-md-3 text-right"><img src="images/right_arrow_small.png" style="max-height:12px;"></div>
            </div>
            <div class="row">
            	<div class="col-xs-6 col-md-5">
                	<span>均价: ¥3280</span>
                </div>
                <div class="col-xs-6 col-md-5">
                	<span>接单数: 126</span>
                </div>
                <div class="col-md-2">
                	<span></span>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-md-12"><hr></div>
    </div>
    <div class="row">
    	<div class="col-xs-4 col-md-4 text-center"><span>专业 : <span class="text-primary">5.0</span></span></div>
        <div class="col-xs-4 col-md-4 text-center"><span>沟通 : <span class="text-success">5.0</span></span></div>
        <div class="col-xs-4 col-md-4 text-center"><span>守时 : <span class="text-warning">5.0</span></span></div>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-md-12"><hr></div>
    </div>
    <div class="row">
    	<div class="col-xs-4 col-md-4"><img src="images/user_district_icon.png" style="max-height:18px"><span>服务商圈</span></div>
        <div class="col-xs-8 col-md-8"><span>沙特、欧盟、美洲、澳洲、龙华、徐家汇、我操、写烦了、那都行、不行我就去月球、上海也行</span></div>
    </div>
    <div class="row">
    	<div class="col-xs-12 col-md-12"><hr></div>
    </div>
    <div class="row">
    	<div class="col-xs-8 col-md-8"><img src="images/user_comment_icon.png" style="max-height:18px"><span>顾客评价(116)</span></div>
        <div class="col-xs-4 col-md-4 text-right"><img src="images/right_arrow_small.png" style="max-height:12px"></div>
    </div>
</div>
	
	
</body>
</html>