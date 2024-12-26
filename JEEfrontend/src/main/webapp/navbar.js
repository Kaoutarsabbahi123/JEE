document.addEventListener("DOMContentLoaded", function () {

    let list = document.querySelectorAll(".navigation li");

    function activeLink() {
        list.forEach((item) => {
            item.classList.remove("active");
        });
        this.classList.add("active");
    }

    list.forEach((item) => item.addEventListener("click", activeLink));

    let toggle = document.querySelector(".toggle");
    let navigation = document.querySelector(".navigation");
    let main = document.querySelector(".main");

    toggle.onclick = function () {
        navigation.classList.toggle("active");
        main.classList.toggle("active");
    };
});
