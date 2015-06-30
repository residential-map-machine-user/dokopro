$.ajax({
    url: "dokopro/front/course/item/",
    type: "POST",
    cache: false,
    dataType: "json",
    data: {
      param1: $('#text1').val(),
      param2: $('#text2').val()
    },
    success: function(o){
      $('#div3').html(o.data1 + " - " + o.data2);
    },
    error: function(xhr, textStatus, errorThrown){
      alert('Error');
    }
  });