/**
 * MIT License
 * @author Barret Lee<http://barretlee.com/about/>
 * @datetime 2015-11-16 20:21:27
 * @change fsy0718 <fsy0718@yeah.net>
 */

~function(window, undefined) {

  var conf = {
    TAG: 'data-src',
    DISTANCE: 0,
    trigger: 'auto'
  }


  // Lazyload Component
  function Lazyload(elements,options) {
     $.extend(true,this,conf,options)
    this.elements = $(elements);
    this.init();
  };

  // init, bind event
  Lazyload.prototype.init = function() {
    var self = this;
    self._detectElementIfInScreen();

    var timer;
    $(window).on("scroll", function() {
      timer && clearTimeout(timer);
      timer = setTimeout(function() {
        self._detectElementIfInScreen();
      }, 50);
    });
   $(window).on("resize", function(){
      timer && clearTimeout(timer);
      self._detectElementIfInScreen();
    });
  };

  // detect if in screen
  Lazyload.prototype._detectElementIfInScreen = function() {
    if(!this.elements.length) return;
    for (var i = 0, len = this.elements.length; i < len; i++) {
      var ele = this.elements[i];
      var rect = ele.getBoundingClientRect();
      if(this.trigger === 'auto' && (rect.top >= this.DISTANCE && rect.left >= this.DISTANCE
        && rect.top <= (window.innerHeight || document.documentElement.clientHeight)
        && rect.left <= (window.innerWidth || document.documentElement.clientWidth) || rect.top < 0 && (rect.top + rect.height) >= this.DISTANCE)) {
        this.loadItem(ele, i);
        this.elements.splice(i, 1);
        i--; len--;
      }
    }
  };

  // lazyload img or script
  Lazyload.prototype.loadItem = function(ele, i) {
    var imgs = ele.getElementsByTagName("img");
    var self = this;
    var deferrArr = []
    for(var i = 0, len = imgs.length; i < len; i++) {
      var img = imgs[i];
      var src = img.getAttribute(this.TAG);
      if(src) {
        if(self.callback){
          var def = $.Deferred()
          deferrArr.push(def)
          img.onload = function(){
            var idx = $(this).data('idx')
            deferrArr[idx] && deferrArr[idx].resolve();
            $(this).data('idx',null)
          }
        }
        $(img).attr('src',src).data('idx',i)
      }
    }
    if(deferrArr.length){
      $.when.apply($,deferrArr).done(function(){
        self.callback(ele,imgs,self)
      })
    }

  };
  window.Lazyload = Lazyload

}(window, void 0);
