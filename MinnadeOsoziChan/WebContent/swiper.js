  const mySwiper_thumb = new Swiper('.gallery01 .swiper-thumb', {
    slidesPerView: 5,
    spaceBetween: 8,
    grabCursor: true,
    scrollbar: {
      el: '.gallery01 .swiper-scrollbar',
      draggable: true,
    },
    breakpoints: {
      600: {
        slidesPerView: 7,
      },
    },
  });

  const mySwiper_main = new Swiper('.gallery01 .swiper-main', {
    effect: 'fade',
    fadeEffect: {
      crossFade: true,
    },
    speed: 500,
    navigation: {
      nextEl: '.gallery01 .swiper-button-next',
      prevEl: '.gallery01 .swiper-button-prev',
    },
    thumbs: {
      swiper: mySwiper_thumb,
    },
	on: {
		beforeTransitionStart: function() {
			const activeLocationId = document.querySelector('.active-location-id');
			activeLocationId.textContent = this.realIndex + 1;
		}
	}
  });


