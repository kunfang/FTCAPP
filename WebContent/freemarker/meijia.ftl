<html lang="zh-CN">
<head>
<#import "header.ftl" as head> 
<@head.header title="美甲"/>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">简约</button>
			</div>
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">彩绘</button>
			</div>
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">明星作品</button>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">法式</button>
			</div>
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">新娘</button>
			</div>
			<div class="col-xs-4 col-md-4">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">日韩</button>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-12">
				<button type="button" class="btn btn-default navbar-btn" style="width: 100%">首次优惠特权39.9元</button>
			</div>
		</div>
        <div class="row sortrow">
        	<div class="col-xs-4 col-md-4 text-center">
            	<span><a href="#" class="sortarr"><p>综合排序</p></a></span>
            </div>
            <div class="col-xs-4 col-md-4 text-center">
            	<span><a href="#" class="sortarr"><p>销量优先</p></a></span>
            </div>
            <div class="col-xs-4 col-md-4 text-center">
            	<span><a href="#" class="sortarr"><p>价格排序</p></a></span>
            </div>
        </div>
        
        <div class="row">
        	<#list prodList as prod>
        	<div class="col-xs-6 col-md-3">
				<div class="thumbnail">
					<a href="meijiamingxi.html">
						<img alt="${prod.prodName}" src="${prod.fileUrl}" class="img-rounded img-responsive" style="width: 100%;height: 150px;max-height: 150px;max-width: 150px;;max-width: 150px;">
					</a>
					<div class="caption">
						<h5>${prod.prodName}</h5>
						<div class="row">
							<div class="col-xs-4 col-md-6">
								<span class="price">
									<span class="price-num">¥${prod.price}</span>
								</span>
							</div>
							<div class="col-xs-8 col-md-6 text-right">
								<span class="total-sale">${prod.totalNum}人做过</span>
							</div>
						</div>
					</div>
				</div>
			</div>
        	</#list>
        </div>
    </div>
</body>
</html>