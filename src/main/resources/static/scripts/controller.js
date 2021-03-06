var availableProducts = null;
var currentUserId = null;

var requestCatalogue = function (locationID) {
    console.log("Requesting cataloge for locationID", locationID);
    $.ajax({
        url: 'http://localhost:8080/catalogue/' + locationID,
        success: function (data) {
            availableProducts = data;
            initializeLists();
        }
    });
};


$("#getProductsButton").click(function (e) {
    e.preventDefault();

    //Clear all lists first
    $("#sports").empty();
    $("#news").empty();
    $("#basket").empty();

    var name = $("#nameField").val();
    var customerID;
    var nameToIdDict = {"Mario": 1, "Luigi": 2, "Zelda": 3};
    customerID = nameToIdDict[name];
    currentUserId = customerID;

    //send location request if id not null
    if (customerID !== null) {
        console.log("Sending location id request for user", name);
        $.ajax({
            url: 'http://localhost:8080/customer_locations/' + customerID,
            success: function (data) {
                var locationID = data.id.id;
                console.log("Received location id", locationID);
                requestCatalogue(locationID);
            }
        });

    } else {
        console.log("Unable to find user", name);
    }
});

$(".checkout").click(function (e) {
    console.log("currentUserId id", currentUserId);
    e.preventDefault();

    var selectedProducts = [];
    $('#basket').find('li').each(function() {
        var id = $(this).attr('id');
        selectedProducts.push(id);
    });

    if(selectedProducts.length === 0){
        console.log("No selected products...");
        return;
    }

    console.log(JSON.stringify({ customerID: currentUserId,  selectedProducts: selectedProducts}));

    $.ajax({
        url: 'http://localhost:8080/checkout',
        method: "POST",
        data: JSON.stringify({ customerID: currentUserId,  selectedProducts: selectedProducts}),
        contentType: 'application/json',
        dataType: 'html',
        success: function(response) {
            console.log("Loading checkout page");
            //$("html").html(response);
            $("body").html(response);
        },
        error: function (xhr, status) {
            console.log(status);
        }
    });

});

var sportProductHolder = document.getElementById("sports");
var newsProductHolder = document.getElementById("news");
var basketHolder = document.getElementById("basket");

var initializeLists = function () {
    console.log("Initializing product lists...");

    var productNames = availableProducts.allProducts;

    for (i = 0; i < productNames.length; i++) {
        var catName = productNames[i].category.name.toLowerCase();
        var prodId = productNames[i].id.id;
        console.log(prodId);
        if (catName === "sports") {
            $("#sports").append('<li id="' + prodId + '" class="sports"><input type="checkbox"><label>' + productNames[i].name + '</label></li>');
        } else if (catName === "news" || catName === "sport news") {
            $("#news").append('<li id="' + prodId + '" class="news"><input type="checkbox"><label>' + productNames[i].name + '</label></li>');
        }
    }

    var i = 0;
    // Cycle over the sportProductHolder ul list items
    for (i = 0; i < sportProductHolder.children.length; i++) {
        // bind events to list item's children (productSelected)
        bindProductEvent(sportProductHolder.children[i], productSelected);
    }
    // Cycle over the newsProductHolder ul list items
    for (i = 0; i < newsProductHolder.children.length; i++) {
        // bind events to list item's children (productSelected)
        bindProductEvent(newsProductHolder.children[i], productSelected);
    }
    // Cycle over the basketHolder ul list items
    for (i = 0; i < basketHolder.children.length; i++) {
        // bind events to list item's children (basket items)
        bindProductEvent(basketHolder.children[i], unselectProduct);
    }
};

// Mark a product as selected
var productSelected = function () {
    console.log("Product selected...");
    //Append the product list item to the #basket
    var listItem = this.parentNode;
    basketHolder.appendChild(listItem);
    bindProductEvent(listItem, unselectProduct);
};

// Mark a task as incomplete
var unselectProduct = function () {
    console.log("Task Incomplete...");
    // When checkbox is unchecked
    // Append the task list item #sports or #news
    var listItem = this.parentNode;
    var itemClass = $(listItem).attr("class");
    console.log("item class", itemClass);
    if (itemClass === "sports") {
        sportProductHolder.appendChild(listItem);
        console.log("Appending to sports");
    } else if (itemClass === "news") {
        console.log("Appending to sports");
        newsProductHolder.appendChild(listItem);
    }
    console.log(availableProducts.allProducts[0].name);
    bindProductEvent(listItem, productSelected);
};

var bindProductEvent = function (taskListItem, checkBoxEventHandler) {
    console.log("Bind list item events");
    //select taskListItem's children
    var checkBox = taskListItem.querySelector("input[type=checkbox]");
    //bind checkBoxEventHandler to checkbox
    checkBox.onchange = checkBoxEventHandler;
};





