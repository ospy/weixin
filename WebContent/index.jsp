<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
<link rel="stylesheet" href="css/weui.css"/>
<title>门特方案、费用查询</title>
</head>
<body>
<div class="weui-toptips weui-toptips_warn js_tooltips">错误提示</div>
<div class="weui-cells__title">表单git</div>
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__hd"><label class="weui-label">医保卡号</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="number" pattern="[0-9]*" placeholder="请输入医保卡号"/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd">
                    <label class="weui-label">身份证号</label>
                </div>
                <div class="weui-cell__bd">
                  <input class="weui-input" type="tel" placeholder="请输入身份证号">
              </div>

            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label for="" class="weui-label">日期</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="date" value=""/>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__hd"><label for="" class="weui-label">时间</label></div>
                <div class="weui-cell__bd">
                    <input class="weui-input" type="datetime-local" value="" placeholder=""/>
                </div>
            </div>
        </div>
        <div class="weui-cells__tips">如不输入起止时间，则默认为最后一次门特</div>

        <div class="weui-cells__title"></div>
        <div class="weui-btn-area">
            <a class="weui-btn weui-btn_primary" href="javascript:alter('你点击了确定按钮');" id="showTooltips">确定</a>
        </div>
</body>
</html>