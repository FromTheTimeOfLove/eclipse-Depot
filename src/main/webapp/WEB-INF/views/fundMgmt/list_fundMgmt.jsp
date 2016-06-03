<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<!--[if IE 8]>
 <html lang="en" class="ie8 no-js">
<![endif]-->
<!--[if IE 9]>
 <html lang="en" class="ie9 no-js">
<![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<jsp:include page="../decorate/contentHead.jsp"></jsp:include>
<style>
	
</style>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body>
    <!-- BEGIN ONE PEGER HEAD-->
            <!-- BEGIN ONE PEGER HEAD WINDOW-->
            <div class="portlet box green">
                <!-- BEGIN ONE PEGER TITLE AND BUTTON -->
                <div class="form-title-min-height">
                </div>
                <!-- END ONE PEGER TITLE AND BUTTON -->
                <!-- BEGIN ONE PEGER QUERY CRITERIA -->
                <div class="portlet-body form">
                    <form class="form-horizontal" id="fundMgmtListForm">
					<input id="hiddenText" type="text" style="display:none" />
                    <div class="form-body form-body-size">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="from-group">
                                    <label class="control-label col-md-2">出资主体名称：</label>
                                    <div class="col-md-3">
                                        <input type="text" class="form-control" name="fundName" placeholder="" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- BEGIN - Here query、 reset, And add button -->
					<div class="form-actions right">
						<div class="row">
							<div class="col-md-12">
								<button type="button" class="btn btn-sm green" id="fundSearchBt">
									<fmt:message key="PAGE.GEN.SEARCH" />
								</button>
								<button type="reset" class="btn btn-sm green" id="fundResetBt">
									<fmt:message key="PAGE.GEN.RESET" />
								</button>
								<button type="button" class="btn btn-sm green" id="fundAddBt">
									<fmt:message key="PAGE.GEN.ADD" />
									<i class="fa fa-plus"> </i>
								</button>
							</div>
						</div>
					</div>
					<!-- END - Here query、 reset, And add button -->
                    </form>
                </div>
                <!-- END ONE PEGER QUERY CRITERIA -->
            </div>
            <!-- END ONE PEGER HEAD WINDOW-->
    <!-- END ONE PEGER HEAD-->
    <!-- BEGIN ONE PEGER LIST BODY -->
    <div class="row">
        <div class="col-md-12">
            <!-- BEGIN ONE PEGER LIST HEAD BODY-->
            <div class="portlet box green">
                <!-- BEGIN ONE PEGER LIST TITLE AND BUTTON -->
                <div class="portlet-title">
                    <!-- BEGIN ONE PEGER LIST TITLE -->
                    <div class="caption">
                        <i class="fa  fa-table"></i>
                                                                         出资主体列表
                    </div>
                    <!-- END ONE PEGER LIST TITLE -->
                    <!-- BEGIN ONE PEGER LIST BUTTON -->
                    <div class="tools">
                        <!-- <a class="collapse" href="javascript:;" data-original-title="" title=""> </a>
                        <a class="reload" href="javascript:;" data-original-title="" title=""> </a> -->
                    </div>
                    <!-- END ONE PEGER LIST BUTTON -->
                </div>
                <!-- END ONE PEGER LIST TITLE AND BUTTON -->
                <!-- BEGIN ONE PEGER LIST CONTENT -->
                <div class="portlet-body form" id="portlet-bodyTable">
                    <!-- BEGIN PAGE CONTENT -->
                        <table id="fundMgmtListTable" class="table table-striped table-bordered table-hover table-advance">
                            <thead>
                                <tr>
                                    <th class="table-width-5">出资主体名称</th>
                                    <th class="table-width-2">币种</th>
                                    <th class="table-width-7">说明</th>
                                    <th class="table-width-1">操作</th>
                                </tr>
                            </thead>
                        </table>
                    <!-- END PAGE CONTENT -->
                </div>
                <!-- END ONE PEGER LIST CONTENT -->
            </div>
            <!-- END ONE PEGER LIST HEAD BODY-->
        </div>
    </div>
    <!-- END ONE PEGER LIST BODY -->
    <jsp:include page="../decorate/contentFoot.jsp"></jsp:include>
    <jsp:include page="../decorate/contentFootJS.jsp"></jsp:include>
    <script src="static/fundMgmt/scripts/fundMgmt.js?randomId=<%=Math.random()%>" type="text/javascript"></script>
    <script type="text/javascript">
		// 执行
	    Fund.init();
    </script>
</body>
</html>
