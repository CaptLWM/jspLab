<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/view/include/header.jspf" %>

   <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        ì¡°ì ë·ì»´
        <small>it all starts here</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Examples</a></li>
        <li class="active">ì¡°ì ë·ì»´</li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      <div class="box">
        <div class="box-header with-border">
          <h3 class="box-title">Title</h3>

          <div class="box-tools pull-right">
            <button type="button" class="btn btn-box-tool" data-widget="collapse" data-toggle="tooltip"
                    title="Collapse">
              <i class="fa fa-minus"></i></button>
            <button type="button" class="btn btn-box-tool" data-widget="remove" data-toggle="tooltip" title="Remove">
              <i class="fa fa-times"></i></button>
          </div>
        </div>
       <h1>ì¡°ì ë·ì»´</h1>
	<div id="news_wrap">
		<h2>
			<!-- ì´ê¸°ì ì²« ë²ì§¸ ë²í¼ìë§ class="on"ì´ í¬í¨ëì´ ììµëë¤. -->
			<a href="https://www.chosun.com/arc/outboundfeeds/rss/?outputType=xml" class="on">
				ì¤ëì ì£¼ìë´ì¤</a>
		</h2>
		<h2>
			<a
				href="https://www.chosun.com/arc/outboundfeeds/rss/category/entertainments/?outputType=xml">ìí°íì´ë¨¼í¸</a>
		</h2>
		<h2>
			<a
				href="https://www.chosun.com/arc/outboundfeeds/rss/category/sports/?outputType=xml">ì¤í¬ì¸ </a>
		</h2>
		<h2>
			<a
				href="https://rss.donga.com/science.xml">ëìì¼ë³´</a>
		</h2>
		<ul id="news_list">
		</ul>
	</div>
        <div class="box-footer">
          Footer
        </div>
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

    <%@ include file="/view/include/footer.jspf" %>