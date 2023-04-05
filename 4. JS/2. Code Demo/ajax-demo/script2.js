var array2 = [];
var table = $("#table tbody");

$(document).ready(function () {
    $.ajax({
        url: "https://dummyjson.com/products",
    }).done(function (result) {
        array2 = structuredClone(result.products);
        console.log(array2);
        for (let i = 0; i < array2.length; i++) {
            add(array2[i]);
            // let price = $("#table").find("tr").eq(i).find("td").eq(4).text();
            // console.log(price);
            calcTotalPrice();
        }

    })

    $("#submit-btn").click(function(){
        $.ajax({
            type: "POST",
            data: {info:array2},
            url: "https://dummyjson.com/products",
            success: function(msg){
              $('.answer').html(msg);
            }
        });
    });

    // add 
    function add(product) {
        $("tbody").append(
            `<tr id="${product.id}">
                <td class="img-cell">
                    <div class="slider">
                        <button class="prev-btn"><i class="fa-solid fa-angle-left"></i></button>
                        <div class="slider-img">
                            
                            <img src="${product.images[0]}" alt="">                    
                            <img src="${product.images[1]}" width alt="">
                            <img src="${product.images[2]}" alt=""> 
                            <img src="${product.images[3]}" alt="">
                            <img src="${product.images[4]}" alt=""> 
                                                     
                        </div>
                        <button class="next-btn"><i class="fa-solid fa-angle-right"></i></button> 
                    </div>
                    
                </td>
                <td class="title-cell cell">
                    ${product.title}
                </td>
                <td class="brand-cell cell">
                    ${product.brand}
                </td>
                <td class="info-cell cell">
                    ${product.description}
                </td>
                <td class="price-cell cell">
                    ${product.price}
                </td>
                <td class="btn-cell">
                    <button class="del-btn">Delete</button>
                    <button class="edit-btn">Edit</button>
                    <button class="save-btn">Save</button>
                </td>
            </tr>`
        )
    }


    // delete
    function remove() {
        $("#table").on("click", ".del-btn", function () {
            let productId = $(this).closest("tr").attr("id");
            $(this).closest("tr").remove();
            const foundIndex = array2.findIndex(object => {
                return object.id == productId;
            })
            array2.splice(foundIndex, 1);
            // console.log(array2);

            calcTotalPrice();
        })
    }
    remove();

    // edit
    function edit() {
        $("#table").on("click", ".edit-btn", function () {
            $("#table tbody .save-btn").css("display", "inline-block");
            $("#table tbody .edit-btn").css("display", "none");

            $(this).closest("tr").find(".cell").each(function () {
                const oldValues = $(this).html();
                $(this).html(`<input type="text" class="edited-inputs value="${oldValues}">`);
                // let productId = $(this).closest("tr").attr("id");
            })
        })
    }
    edit();

    // save
    function save() {
        $("#table").on("click", ".save-btn", function () {

            const newTitle = $("#table").find(".title-cell input").val();
            $(this).closest("tr").find(".title-cell").text(newTitle);

            const newBrand = $("#table").find(".brand-cell input").val();
            $(this).closest("tr").find(".brand-cell").text(newBrand);

            const newInfo = $("#table").find(".info-cell input").val();
            $(this).closest("tr").find(".info-cell").text(newInfo);

            const newPrice = $("#table").find(".price-cell input").val();
            $(this).closest("tr").find(".price-cell").text(newPrice);

            // $(this).closest("tr").find(".cell").each(function () {
            //     const value = $(this).find("input").val();
            //     $(this).text(value);
            // })


            const product = {
                title: newTitle,
                brand: newBrand,
                desc: newInfo,
                price: newPrice,
            };

            // const product = {
            //     title: $(this).find(".title-cell input").val(),
            //     brand: $(this).find(".brand-cell input").val(),
            //     desc: $(this).find(".info-cell input").val(),
            //     price: $(this).find(".price-cell input").val(),
            // };

            let productId = $(this).closest("tr").attr("id");

            const foundIndex = array2.findIndex(x => x.id == productId);
            array2[foundIndex] = product;

            console.log(array2);
            $("#table tbody .edit-btn").css("display", "inline-block");
            $("#table tbody .save-btn").css("display", "none");

            calcTotalPrice();

        })
    }
    save();


    // calc Total Price
    function calcTotalPrice() {
        const rowLength = $("#table tr").length;
        let total = 0;
        for (let i = 0; i < rowLength - 1; i++) {
            let price = Number($("#table").find("tr").eq(i).find("td").eq(4).text());
            total += price;
            $("#table tfoot td").eq(1).text(total).css("text-align", "center");
        }
    }

    function slide() {
        $("table").on("click", ".next-btn", function() {
            var left = $(this).parents().find(".slider-img");
            left.scrollBy(-400, 0);
        })
    }

    slide();
     

})


// $(document).ready(function(){
//     $(".submit-btn").click(function(){
//         $.ajax({
//             type: "POST",
//             data: {info:array2},
//             url: "https://dummyjson.com/products",
//             success: function(msg){
//               $('.answer').html(msg);
//             }
//         });
//     });
// });


