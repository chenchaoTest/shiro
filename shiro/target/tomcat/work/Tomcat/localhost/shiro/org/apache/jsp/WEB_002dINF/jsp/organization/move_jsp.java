/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-09-20 09:30:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.organization;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class move_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title></title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/css/css.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css\">\n");
      out.write("    <style>\n");
      out.write("        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <form id=\"form\" method=\"post\">\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>源节点名称：</label>\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${source.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"form-group\">\n");
      out.write("            <label>目标节点名称：</label>\n");
      out.write("            <input type=\"text\" id=\"targetName\" readonly=\"true\"/>\n");
      out.write("            <input type=\"hidden\" id=\"targetId\" name=\"targetId\"/>\n");
      out.write("            <a id=\"menuBtn\" href=\"#\">选择</a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"移动\"/>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    <div id=\"menuContent\" class=\"menuContent\" style=\"display:none; position: absolute;\">\n");
      out.write("        <ul id=\"tree\" class=\"ztree\" style=\"margin-top:0; width:160px;\"></ul>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/js/jquery-1.11.0.min.js\"></script>\n");
      out.write("    <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        $(function () {\n");
      out.write("            var setting = {\n");
      out.write("                view: {\n");
      out.write("                    dblClickExpand: false\n");
      out.write("                },\n");
      out.write("                data: {\n");
      out.write("                    simpleData: {\n");
      out.write("                        enable: true\n");
      out.write("                    }\n");
      out.write("                },\n");
      out.write("                callback: {\n");
      out.write("                    onClick: onClick\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            var zNodes =[\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("            ];\n");
      out.write("\n");
      out.write("            function onClick(e, treeId, treeNode) {\n");
      out.write("                var zTree = $.fn.zTree.getZTreeObj(\"tree\"),\n");
      out.write("                        nodes = zTree.getSelectedNodes(),\n");
      out.write("                        id = \"\",\n");
      out.write("                        name = \"\";\n");
      out.write("                nodes.sort(function compare(a,b){return a.id-b.id;});\n");
      out.write("                for (var i=0, l=nodes.length; i<l; i++) {\n");
      out.write("                    id += nodes[i].id + \",\";\n");
      out.write("                    name += nodes[i].name + \",\";\n");
      out.write("                }\n");
      out.write("                if (id.length > 0 ) id = id.substring(0, id.length-1);\n");
      out.write("                if (name.length > 0 ) name = name.substring(0, name.length-1);\n");
      out.write("                $(\"#targetId\").val(id);\n");
      out.write("                $(\"#targetName\").val(name);\n");
      out.write("                hideMenu();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function showMenu() {\n");
      out.write("                var cityObj = $(\"#targetName\");\n");
      out.write("                var cityOffset = $(\"#targetName\").offset();\n");
      out.write("                $(\"#menuContent\").css({left:cityOffset.left + \"px\", top:cityOffset.top + cityObj.outerHeight() + \"px\"}).slideDown(\"fast\");\n");
      out.write("\n");
      out.write("                $(\"body\").bind(\"mousedown\", onBodyDown);\n");
      out.write("            }\n");
      out.write("            function hideMenu() {\n");
      out.write("                $(\"#menuContent\").fadeOut(\"fast\");\n");
      out.write("                $(\"body\").unbind(\"mousedown\", onBodyDown);\n");
      out.write("            }\n");
      out.write("            function onBodyDown(event) {\n");
      out.write("                if (!(event.target.id == \"menuBtn\" || event.target.id == \"menuContent\" || $(event.target).parents(\"#menuContent\").length>0)) {\n");
      out.write("                    hideMenu();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            $.fn.zTree.init($(\"#tree\"), setting, zNodes);\n");
      out.write("            $(\"#menuBtn\").click(showMenu);\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/organization/move.jsp(54,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/organization/move.jsp(54,16) '${targetList}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${targetList}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/jsp/organization/move.jsp(54,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("o");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                { id:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(", pId:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.parentId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(", name:\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\", open:");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${o.rootNode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("},\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
