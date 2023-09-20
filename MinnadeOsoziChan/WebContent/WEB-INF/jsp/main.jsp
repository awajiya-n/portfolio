<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta name="robots" content="noindex" />
    <meta charset="UTF-8">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="width=device-width">
    <title>Document</title>

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/swiper.css" />
	<style>
		@import url("https://fonts.googleapis.com/css2?family=Spartan:wght@400;700&display=swap");
		 :root {
		   --easing: cubic-bezier(.2, 1, .2, 1);
		   --transition: .8s var(--easing);
		   --color-base: #f8f8f8;
		   --color-gray: #ddd;
		   --color-theme: #f5695f;
		   --color-theme-darken: #f12617;
		   --box-shadow: .8rem .8rem 1.2rem rgba(0, 0, 0, .05), -.8rem -.8rem 1.2rem #fff;
		   --box-shadow-hover: 1rem 1rem 1.5rem rgba(0, 0, 0, .08), -1rem -1rem 1.5rem #fff;
		   --box-shadow-inset: inset .8rem .8rem 1.2rem rgba(0, 0, 0, .05), inset -.8rem -.8rem 1.2rem #fff;
		   --box-shadow-dark: .8rem .8rem 1.2rem rgba(0, 0, 0, .1), -.8rem -.8rem 1.2rem rgba(#fff,.2);
		 }

		 html {
		   font-family: "Spartan", "游ゴシック体", YuGothic, "游ゴシック", "Yu Gothic", "メイリオ", Meiryo, sans-serif;
		   font-size: 62.5%;
		   line-height: 1.8;
		   height: 100%;
		   word-break: break-word;
		   color: #333;
		   background-color: var(--color-base);
		   -webkit-appearance: none;
		   -webkit-tap-highlight-color: transparent;
		 }

		 body {
		   font-size: 1.6rem;
		   margin: 0;
		 }

		 *,
		 *::before,
		 *::after {
		   -webkit-box-sizing: border-box;
		           box-sizing: border-box;
		 }

		 ::-moz-selection {
		   color: #fff;
		   background: var(--color-theme);
		 }

		 ::selection {
		   color: #fff;
		   background: var(--color-theme);
		 }

		 img {
		   border: 0;
		   margin: 0;
		 }

		 figure {
		   margin: 0;
		 }

		 p {
		   margin: 0;
		   padding: 0;
		 }

		 a {
		   text-decoration: none;
		   color: #333;
		 }

		 ul,
		 ol {
		   margin: 0;
		   padding: 0;
		   list-style: none;
		 }

		 h1,
		 h2,
		 h3,
		 h4,
		 h5,
		 h6 {
		   font-size: 1.6rem;
		   margin: 0;
		   padding: 0;
		 }

		 main {
		   display: block;
		 }

		 .l-inner {
		   position: relative;
		   -webkit-box-sizing: content-box;
		           box-sizing: content-box;
		   max-width: 1200px;
		   margin: 0 auto;
		   padding: 0 10rem;
		 }

		 .l-section {
		   border-top: 1px solid #eee;
		 }
		 .l-section .l-inner {
		   padding-top: 8rem;
		   padding-bottom: 8rem;
		 }

		 [class*=swiper]:focus {
		   outline: none;
		 }

		 .slide-media,
		 .thumb-media {
		   position: relative;
		   overflow: hidden;
		 }
		 .slide-media img,
		 .thumb-media img {
		   position: absolute;
		   top: 0;
		   left: 0;
		   width: 100%;
		   height: 100%;
		   -o-object-fit: cover;
		      object-fit: cover;
		 }


		 .swiper-button-prev, .swiper-button-next {
		   display: grid;
		   place-content: center;
		   width: 6.4rem;
		   height: 6.4rem;
		   cursor: pointer;
		   -webkit-transition: var(--transition);
		   transition: var(--transition);
		 }
		 .swiper-button-prev::before, .swiper-button-next::before {
		   position: absolute;
		   top: 0;
		   right: 0;
		   bottom: 0;
		   left: 0;
		   content: "";
		   border-radius: 50%;
		   -webkit-box-shadow: var(--box-shadow);
		           box-shadow: var(--box-shadow);
		 }
		 .swiper-button-prev::after, .swiper-button-next::after {
		   width: 1.2rem;
		   height: 1.2rem;
		   content: "";
		   border: solid var(--color-gray);
		   border-width: 3px 3px 0 0;
		 }
		 .swiper-button-prev::after {
		   margin-left: 0.4rem;
		   -webkit-transform: rotate(-135deg);
		           transform: rotate(-135deg);
		 }
		 .swiper-button-next::after {
		   margin-right: 0.4rem;
		   -webkit-transform: rotate(45deg);
		           transform: rotate(45deg);
		 }
		 .swiper-button-disabled {
		   pointer-events: none;
		   opacity: 0;
		 }

		 .gallery01 {
		   overflow: hidden;
		 }
		 .gallery01 .swiper {
		   max-width: 720px;
		   margin: auto;
		 }
		 .gallery01 .swiper-main {
		   overflow: visible;
		 }
		 .gallery01 .swiper-thumb {
		   padding-top: 8px;
		 }
		 .gallery01 .swiper-fade .swiper-slide {
		   -webkit-transition-property: opacity, -webkit-transform !important;
		   transition-property: opacity, -webkit-transform !important;
		   transition-property: opacity, transform !important;
		   transition-property: opacity, transform, -webkit-transform !important;
		   pointer-events: none;
		 }
		 .gallery01 .swiper-fade .swiper-slide-active {
		   pointer-events: auto;
		 }
		 .gallery01 .swiper-controller {
		   position: absolute;
		   top: 0;
		   left: 0;
		   width: 100%;
		   padding-top: 62.5%;
		 }
		 .gallery01 .swiper-button-prev, .gallery01 .swiper-button-next {
		   position: absolute;
		   z-index: 1;
		   top: 0;
		   bottom: 0;
		   margin: auto;
		 }
		 .gallery01 .swiper-button-prev {
		   right: calc(100% + 3.2rem);
		 }
		 .gallery01 .swiper-button-next {
		   left: calc(100% + 3.2rem);
		 }
		 .gallery01 .swiper-scrollbar {
		   position: relative;
		   margin-top: 1.6rem;
		 }
		 .gallery01 .swiper-scrollbar::after {
		   position: absolute;
		   z-index: -1;
		   top: 0;
		   bottom: 0;
		   left: 0;
		   width: 100%;
		   height: 4px;
		   margin: auto;
		   content: "";
		   background-color: #eee;
		 }
		 .gallery01 .swiper-scrollbar-drag {
		   height: 20px;
		   padding: 8px 0;
		   cursor: pointer;
		   background-color: var(--color-theme);
		   background-clip: content-box;
		 }
		 .gallery01 .swiper-scrollbar-drag:active {
		   background-color: var(--color-theme-darken);
		 }
		 .gallery01 .slide {
		   display: block;
		   overflow: hidden;
		 }
		 .gallery01 .slide-media {
		   padding-top: 62.5%;
		   border-radius: 4px;
		 }
		 .gallery01 .slide-media img {
		   -o-object-fit: contain;
		      object-fit: contain;
		 }
		 .gallery01 .slide-title {
		   font-weight: bold;
		   line-height: 1.6;
		   padding: 3.2rem 0;
		 }
		 .gallery01 .thumb-media {
		   padding-top: 100%;
		   -webkit-transition: var(--transition);
		   transition: var(--transition);
		   border-radius: 4px;
		 }
		 .gallery01 .thumb-media img {
		   height: calc(100% + 8px);
		   -webkit-transition: var(--transition);
		   transition: var(--transition);
		   -webkit-transform: translateY(-8px);
		           transform: translateY(-8px);
		 }
		 .gallery01 .swiper-slide-thumb-active {
		   -webkit-transition: var(--transition);
		   transition: var(--transition);
		   opacity: 0.3;
		 }
		 .gallery01 .swiper-slide-thumb-active .thumb-media {
		   -webkit-transform: translateY(-8px);
		           transform: translateY(-8px);
		 }
		 .gallery01 .swiper-slide-thumb-active .thumb-media img {
		   -webkit-transform: translateY(0);
		           transform: translateY(0);
		 }

		.chara-img {
		  width: 30%;
		  height: 30%;
		  margin-top: -250px;
		  margin-left: １00px;
		  opacity: .8;
		 }

		 @media only screen and (max-width: 1024px) {
		   html {
		     -webkit-text-size-adjust: 100%;
		   }
		   .l-inner {
		     padding: 0 4rem;
		   }
		   .pc {
		     display: none !important;
		   }
		   .gallery01 .swiper-button-prev::before, .gallery01 .swiper-button-next::before {
		     background-color: rgba(0, 0, 0, 0.3);
		     -webkit-box-shadow: var(--box-shadow-dark);
		             box-shadow: var(--box-shadow-dark);
		   }
		   .gallery01 .swiper-button-prev::after, .gallery01 .swiper-button-next::after {
		     border-color: #fff;
		   }
		   .gallery01 .swiper-button-prev {
		     right: calc(100% - 3.2rem);
		   }
		   .gallery01 .swiper-button-next {
		     left: calc(100% - 3.2rem);
		   }
		 }

		 @media only screen and (max-width: 599px) {
		   html {
		     font-size: 50%;
		   }
		   .pc-tab {
		     display: none !important;
		   }
		 }

		 @media only screen and (min-width: 1025px) {
		   .tab-sp {
		     display: none !important;
		   }
		   .swiper-button-prev::before, .swiper-button-next::before {
		     -webkit-transition: var(--transition);
		     transition: var(--transition);
		   }
		   .swiper-button-prev:hover::before, .swiper-button-next:hover::before {
		     -webkit-transform: scale(1.2);
		             transform: scale(1.2);
		   }
		   .gallery01 .swiper-scrollbar-drag:hover {
		     background-color: var(--color-theme-darken);
		   }
		   .gallery01 .thumb-media:hover {
		     -webkit-transform: translateY(-8px);
		             transform: translateY(-8px);
		   }
		   .gallery01 .thumb-media:hover img {
		     -webkit-transform: translateY(0);
		             transform: translateY(0);
		   }
		 }

		 @media only screen and (min-width: 600px) {
		   .sp {
		     display: none !important;
		   }
		 }

		 .header-title {
		 text-align: center;
		 font-size: 20px;
		 }

		 .buttons {
		 display: flex;
		 justify-content: flex-end;
		 padding: ;
		 margin: 5px;
		 }

		 .buttons button {
		 margin: 5px;
		 }

		 .user-info {
		 display: flex;
		 justify-content: space-around;
		 }

		 .user-info li {
		 margin: 0 5px;
		 }

		 .event-list {
		 display: flex;
		 white-space: nowrap;
		 overflow: hidden;
		 gap: 1rem;
		 }

		 .event-list li {
		 animation: marquee 40s infinite linear 1s both;
		 margin: 0 50px;
		 }

		 @keyframes marquee {
			 0% {
			 translate: 0;
			 }
			 100% {
			 translate: calc(-200% - 1rem);
			 }
		 }



	</style>
</head>
<body>
	<header>
	<%-- タイトル, ようこそ○○さん --%>
	<%-- マイページ情報:Group_id, Group_name, User_id, User_name, Earned_Point --%>
	<%-- aside : ボタン(管理者画面・ログアウト・ごほうび交換) --%>
	<%-- イベント情報の表示：3件程箇条書き　or　流れる表示 --%>
		<h1 class="header-title">
		        お掃除ちゃん  マイページ
		</h1>
		<nav class="buttons">
			<form action="/MinnadeOsoziChan/StartServlet" method="get" >
	           	<button type="submit">ログアウト</button>
            </form>
            <form action="#" method="get" >
	           	<button type="submit">ごほうび交換</button>
            </form>

		</nav>

		<ul class="user-info">
		    <li>グループID:${account.groupId}</li>
		    <li>グループ名:${account.groupName}</li>
		    <li>ユーザーID:${account.userId}</li>
		    <li>ユーザー名:${account.userName}</li>
		    <c:set var="activeUserId" value="${account.userId }"  />
		    <li>獲得ポイント:${totalPoint[activeUserId - 1].totalPoint}</li>
		</ul>

		<hr>

		<div class="wrap-event-list">
			<ul class="event-list">

				<c:forEach var="ev" items="${event}">
					<li>期間:<c:out value="${ev.startDate}" /> ~ <c:out value="${ev.endDate}" />---  内容:<c:out value="${ev.text}" /></li>
				</c:forEach>

			</ul>
		</div>

	</header>
	<main>
    <%-- 掃除記録：画像,掃除記録ボタン　ページ遷移アイコン --%>
    <%-- 掃除履歴：2023年　9月6日　5件程 --%>

    	 <div id="demo07" class="gallery01 l-section">
            <div class="l-inner">


                <div class="swiper swiper-main">
                    <div class="swiper-wrapper">
                        <c:forEach var="i" begin="0" end="${ fn:length( locationInfo ) -1 }" step="1">
                            <div class="swiper-slide">
                                <figure class="slide">
                                <div class="slide-media"><img src="${locationInfo[i].roomPngPath}" alt=""></div>
                                <div class="slide-media chara-img"><img src="${locationInfo[i].charaPngPath}" alt=""></div>
                                <figcaption class="slide-title">最終掃除日:${locationInfo[i].lateCleanedDate} 掃除した人:${locationInfo[i].doneName}</figcaption>
	                                <form action="/MinnadeOsoziChan/MainRegistServlet" method="get" >
	                                	<textarea name="active-location-id" class="active-location-id" cols="30" rows="1" hidden>${locationInfo[i].locationId}</textarea>
	                                	<button class="slide-button" type="submit">掃除を記録する</button>
	                                </form>
                                </figure>
                            </div>
                        </c:forEach>



                    </div><!-- /swiper-wrapper -->
                    <div class="swiper-controller">
                    <div class="swiper-button-prev"></div>
                    <div class="swiper-button-next"></div>
                    </div>
                </div><!-- /swiper-main -->

                <div class="swiper swiper-thumb">
                    <div class="swiper-wrapper">
                        <c:forEach var="i" begin="0" end="${ fn:length( locationInfo ) -1 }" step="1">
                            <div class="swiper-slide">
                                <div class="thumb-media"><img src="${locationInfo[i].roomPngPath}" alt=""></div>
                            </div>
                        </c:forEach>

                    </div><!-- /swiper-wrapper -->
                    <div class="swiper-scrollbar"></div>
                </div><!-- /swiper-thumb -->

            </div>
        </div>


	</main>

	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script src="${pageContext.request.contextPath}/swiper.js"></script>

</body>
</html>