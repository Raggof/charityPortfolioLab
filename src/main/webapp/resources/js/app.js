document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep++;
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation

      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }

  const checkboxListCat = document.querySelectorAll("input[name=categories]");
  const cateSumm = document.getElementById("formCatSum");

  function getCheckedCat(){
    let arrayOfCat=[];
    for (let i = 0; i < checkboxListCat.length; i++){
      let checkbox = checkboxListCat[i];
      if (checkbox.checked) {
        arrayOfCat.push(checkboxListCat[i].nextElementSibling.nextElementSibling.nextElementSibling.textContent);
      }
    }
    let catSumm = "";

    if(arrayOfCat === undefined || arrayOfCat.length === 0) {
      catSumm = "Brak wybranej kategirii! Wróć do 1 kroku."
    } else if (arrayOfCat !== null){
      catSumm = arrayOfCat[0] + "";
    }
    for (let j = 1; j < arrayOfCat.length;j++){
      catSumm = catSumm + ", "+ arrayOfCat[j];
    }
    cateSumm.innerText = catSumm;
  }

  const buttonSumm1 = document.getElementById("summ1");
  buttonSumm1.addEventListener("click",function (){
    getCheckedCat();
  });

  const quanform = document.querySelector("input[id=quantity]");
  const quanSumm = document.getElementById("formQuanSum");

  function sendQuan(){
    let quanSummView="";

    if(quanform.value === "" || quanform.value === 0) {
      quanSummView = "Brak podania ilości worków lub podano liczbę 0! Wróć do 2 kroku."
    } else if (quanform.value !== null){
      quanSummView = quanform.value + "";
    }

    quanSumm.innerText = quanSummView;

  }

  const buttonSumm2 = document.getElementById("summ2");
  buttonSumm2.addEventListener("click", function (){
    sendQuan();
  })

  const radiobListInsti = document.querySelectorAll("input[name=institution]");
  const instiSumm = document.getElementById("formInstitSum")

  function getCheckInsti(){
    const arrayOfInsti=[];

    for (let i = 0; i < radiobListInsti.length; i++){
      let radioCheck = radiobListInsti[i];
      if (radioCheck.checked) {
        arrayOfInsti.push(radiobListInsti[i].nextElementSibling.nextElementSibling.getElementsByClassName("title").item(0).firstElementChild.textContent);
      }
    }

    let instSummView = "";

    if( arrayOfInsti === undefined || arrayOfInsti.length === 0) {
      instSummView = "Brak wybranej instytucji! Wróć do 3 kroku."
    } else if (arrayOfInsti !== null){
      instSummView = arrayOfInsti[0] + "";
    }
    for (let j = 1; j < arrayOfInsti.length;j++){
      instSummView = instSummView + ", "+ arrayOfInsti[j];
    }

    instiSumm.innerText = instSummView;
  }
  const buttonSumm3 = document.getElementById("summ3");
  buttonSumm3.addEventListener("click",function (){
    getCheckInsti();
  })

  const streetVal = document.querySelector("input[id=street]");
  const cityVal = document.querySelector("input[id=city]");
  const zipCodeVal = document.querySelector("input[id=zipCode]");
  const phoneVal = document.querySelector("input[id=phoneNumber]");
  const dateVal = document.querySelector("input[id=pickUpDate]");
  const timeVal = document.querySelector("input[id=pickUpTime]");
  const commVal = document.getElementById("pickUpComment");

  const streetSumm = document.getElementById("formStreetSum");
  const citySumm = document.getElementById("formCitySum");
  const citySumm2 = document.getElementById("formCitySum2");
  const zipCodeSumm = document.getElementById("formZipCodeSum");
  const phoneSumm = document.getElementById("formPhoneNumberSum");
  const dateSumm = document.getElementById("formDataSum");
  const timeSumm = document.getElementById("formTimeSum");
  const commSumm = document.getElementById("formCommForCourierSum");

  function sendLocationDate(){
    if (streetVal.innerText === ""){streetSumm.innerText = "Brak nazwy ulicy!"} else {streetSumm.innerText = streetVal.value;}
    if (cityVal.innerText === ""){citySumm.innerText = "Brak nazwy ulicy!"; citySumm2.innerText = "Brak nazwy ulicy!";} else {citySumm.innerText = cityVal.value; citySumm2.innerText = cityVal.value;}
    if (zipCodeVal.value === ""){zipCodeSumm.innerText = "Brak kodu pocztowego!"} else {zipCodeSumm.innerText = zipCodeVal.value;}

    let counter=0;
    let beforeSepa = phoneVal.value+"";
    let sepaPhone="";

    if (phoneVal.innerText === ""){phoneSumm.innerText = "Brak numeru telefonu!"} else {
      citySumm.innerText = cityVal.value;
      for (let x = 0; x < beforeSepa.length; x++) {
        sepaPhone = sepaPhone + beforeSepa.charAt(x);
        counter++;
        if (counter === 3) {
          sepaPhone = sepaPhone + " ";
          counter = 0;
        }
      }
    }

    if (dateVal.value === ""){dateSumm.innerText = "Brak wybranej daty!"} else {dateSumm.innerText = dateVal.value;}

    if (timeVal.value === ""){timeSumm.innerText = "Brak podania godziny!"} else {timeSumm.innerText = timeVal.value;}

    if (commVal.value === ""){commSumm.innerText = "Brak uwag.";} else {commSumm.innerText = commVal.value;}
  }

  const buttonSumm4 = document.getElementById("summ4");
  buttonSumm4.addEventListener("click", function (){
    sendLocationDate();
  })
});
