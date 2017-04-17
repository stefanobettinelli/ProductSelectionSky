var availableProducts;

$.ajax({
    url: 'http://localhost:8080/catalogue/1',
    success: function(data) {
        availableProducts = data;
        initializeLists();
    }
});

var sportProductHolder = document.getElementById("sports");
var newsProductHolder = document.getElementById("news");
var basketHolder = document.getElementById("basket");

var initializeLists = function () {
    console.log("Initializing product lists...");
    var productNames = availableProducts.allProducts;
    for (i = 0; i < productNames.length; i++) {
        console.log(productNames[i].name);
        $("#sports").append('<li class="sports"><input type="checkbox"><label>' + productNames[i].name +  '</label><input type="text"> </li>');
    }
};

// Mark a product as selected
var productSelected = function () {
    console.log("Product selected...");
    //Append the product list item to the #basket
    var listItem = this.parentNode;
    basketHolder.appendChild(listItem);
    bindProductEvent(listItem, taskIncomplete);
};

// Mark a task as incomplete
var taskIncomplete = function () {
    console.log("Task Incomplete...");
    // When checkbox is unchecked
    // Append the task list item #sports
    var listItem = this.parentNode;
    var itemClass = $(listItem).attr("class");
    console.log("item class",itemClass);
    if (itemClass === "sports") {
        sportProductHolder.appendChild(listItem);
    } else if (itemClass === "news") {
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

// Cycle over the sportProductHolder ul list items
for (var i = 0; i < sportProductHolder.children.length; i++) {
    // bind events to list item's children (productSelected)
    bindProductEvent(sportProductHolder.children[i], productSelected);
}
// Cycle over the newsProductHolder ul list items
for (var i = 0; i < newsProductHolder.children.length; i++) {
    // bind events to list item's children (productSelected)
    bindProductEvent(newsProductHolder.children[i], productSelected);
}
// Cycle over the basketHolder ul list items
for (var i = 0; i < basketHolder.children.length; i++) {
    // bind events to list item's children (basket items)
    bindProductEvent(basketHolder.children[i], taskIncomplete);

}





