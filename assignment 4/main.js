let input_elem = document.getElementById("input_num");
let submit_btn = document.getElementById("submit");

let num1 = "";
let num2 = "";
let op = "";

let operators = ["*", "+", "-", "/", "="];

let isnum1_entered = false;

function getInputValue(elem) {
  let value = elem.innerText;

  if (operators.includes(value)) {
    input_elem.value = "";
    if (value == "=") {
      isnum1_entered = !isnum1_entered;
    }
  } else {
    input_elem.value += value;
    !isnum1_entered ? (num1 += value) : (num2 += value);
  }
  console.log(num1);
  console.log(num2);
}

submit_btn.addEventListener("click", () => {
  console.log();
});
