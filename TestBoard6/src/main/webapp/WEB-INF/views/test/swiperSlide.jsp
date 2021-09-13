<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">

  <head>
    <meta charset="UTF-8">
    <title>swiper js</title>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <style>
      html,
      body {
        height: 100%;
      }

      .swiper-container {
        width: 50%;
        height: 20%;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        display: flex;
        justify-content: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }

    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	<script>
    	$(document).ready(function() {
	      let swiper = new Swiper(".mySwiper", {
	        spaceBetween: 30,
	        centeredSlides: true,
	        autoplay: {
	          delay: 5000,
	          disableOnInteraction: false,
	        },
	        pagination: {
	          el: ".swiper-pagination",
	          clickable: true,
	        },
	        navigation: {
	          nextEl: ".swiper-button-next",
	          prevEl: ".swiper-button-prev",
	        },
	      });
		});
    </script>
  </head>

  <body>
    <!-- Swiper -->
    <div class="swiper-container mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <img src="https://placeimg.com/640/480/any" />
        </div>
        <div class="swiper-slide">
          <img src="https://placeimg.com/640/480/animals" />
        </div>
        <div class="swiper-slide">
          <img src="https://placeimg.com/640/480/nature" />
        </div>
        <div class="swiper-slide">
          <img src="https://placeimg.com/640/480/people" />
        </div>
        <div class="swiper-slide">
          <img src="https://placeimg.com/640/480/tech" />
        </div>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </div>
  </body>

</html>