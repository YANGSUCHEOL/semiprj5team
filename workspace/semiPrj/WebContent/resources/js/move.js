$("document").ready(function () {
    // 문서의 dom이 준비되면
    // .mySwiper 클래스를 swiper 슬라이더로 만듦
    // 이후에 swiper변수에 할당했기 때문에 스크립트로 제어할 수도 있음.
    var swiper = new Swiper(".mySwiper", {
		slidesPerView: 2,
		centerdSlides: true,
        spaceBetween: 6,
        autoplay: {
			delay: 2500,
			disableOnInteraction: false,
		},
        loop: true,
        pagination: { // 호출(pager) 여부
        	el: ".swiper-pagination",
        	type: 'bullet',
        	clickable: true
        },
        // 좌우 화살표 navigation element 지정
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev"
        },

        on: {
            init: function() {
                $('.swiper-slide').addClass('changed');

                // fraction에 현재 인덱스와 전체 인덱스 표시
                // this.loopedSlides는 loop, slidesPerView: 'auto'일 때 제대로 동작
                $('.custom-fraction .current').text(this.realIndex + 1);
                $('.custom-fraction .all').text(this.loopedSlides);
            },

            slideChangeTransitionStart: function() {
                // 기본적으로 제공하는 swiper-slide-active 클래스를 이용해
                // css transition 애니메이션 작성 가능하다.
                // 다만 루프 모드일 때에는 루프 픽스를 하며 slide를 바꿔치기를 하는데,
                // 이 때 플리커링이 발생할 수 있다.
                // css transition을 서로 다르게 설정한 changed, changing 클래스를 이용
                $('.swiper-slide').addClass('changing');
                $('.swiper-slide').removeClass('changed');

                // 페이지 넘어갈 때마다 fraction 현재 인덱스 변경
                $('.custom-fraction .current').text(this.realIndex + 1);
            },

            slideChangeTransitionEnd: function() {
                // changing : transition O
                // changed : transition X
                $('.swiper-slide').removeClass('changing');
                $('.swiper-slide').addClass('changed');
            }
        },
    });

});