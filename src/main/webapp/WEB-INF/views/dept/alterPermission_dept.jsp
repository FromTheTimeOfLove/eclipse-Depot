<!DOCTYPE html PUBLIC "-//IETF//DTD HTML 2.0//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- ztree begin -->
<link rel="stylesheet" href="<%=basePath%>static/common/plugins/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<!-- zree end -->
<div id="DEPT_ROLE_DIV" class="form dd-edit-form">
	<ul id="permissionDeptTree" class="ztree"></ul>
	<div class="form-body"  style="display: none;">
		<div class="form-actions">
			<div class="row">
				<div class="col-md-12" align="center">
					<!-- <button type="button" class="btn btn-primary" id="saveUserBt" onclick="Deptment.deptRolePermission();">
						<fmt:message key="PAGE.GEN.SAVE" />
					</button>
					 -->
				</div>
			</div>
		</div>
	</div>
</div>
<!-- ztree begin -->
<script type="text/javascript" src="static/common/plugins/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="static/common/plugins/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="static/common/plugins/ztree/js/jquery.ztree.exhide-3.5.js"></script>
<!-- ztree end -->
<script>
	$(function(){
		initPermissionTree();
	});

	function initPermissionTree() {
		var zNodes;
		var setting = {
			check : {
//				chkStyle: "radio ",//单选框
				enable : false,
			},
			data : {
				simpleData : {
					enable : true
				}
			},
			callback: {
				onClick: zTreeOnClick
			}
		};

		$.ajax({
			async : false,
			cache : false,
			type : 'POST',
			dataType : "json",
//			data : {
//				"roleId" : roleId
//			},
			url : 'rest/dept/findDeptPermissionTree.do',// 请求的action路径
			error : function() {// 请求失败处理函数
				bootbox.alert({
					size : 'small',
					message : i18n.t('GENERAL.FAIL')
				});
			},
			success : function(data) { // 请求成功后处理函数。
				zNodes = data; // 把后台封装好的简单Json格式赋给treeNodes
			}
		});
		$.fn.zTree.init($("#permissionDeptTree"), setting, zNodes);
//		bootbox.hideAll(); // 隐藏所有的bootbox
	};
	
	function zTreeOnClick(event, treeId, treeNode) {
	    $("#parentdeptname").val(treeNode.name);
	    $("#parentdeptid").val(treeNode.id);
	};
</script>