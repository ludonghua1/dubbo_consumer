
(function($){
         $.fn.scrollPoint = function (opts) {
            var def = {
               point: '.nav-word',
               container: '.brand-char',
               scrollDis: 0
            };
            var set = $.extend({}, def, opts);
            return this.each(function () {
               $(set.point).eq(0).addClass('cur');
               $(set.point).on('click', function () {
                  var nav = $(this).data('nav');
                  $( "html,body" ).animate({
                    scrollTop: $('#'+nav).offset().top - set.scrollDis
                  }, 'slow');
               });

               var scroll = new getOffsetTop(set.container, set.point, set.scrollDis);
               scroll.initTopValue();
               scroll.getPostion();
            });
         }
         function getOffsetTop(container, point, h){
               this.tagId = [];
               this.con = container;
               this.point = point;
               this.h = h;
            }

            getOffsetTop.prototype = {
               initTopValue: function () {
                  var that = this;
                  $(this.con).each(function (idx, val) {
                     var top = $(this).offset().top;
                     var elem = $(this).attr('id');
                     that.tagId.push({ id: elem, top: top});
                  });
               },
               getPostion: function () {
                  var that = this;
                  $(window).scroll(function () {
                     $.each(that.tagId, function (idx, val) {
                        if ($(window).scrollTop() >= val.top - that.h - 5) {
                           $(that.point+'[data-nav='+ val.id +']').addClass('cur').siblings().removeClass('cur');
                        }
                     });
                  });
               }
            }
      })(jQuery);