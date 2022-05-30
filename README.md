<h1>В проекте реализованы тесты для мобильного приложения калькулятор</h1>
Проект создан в рамках обучения в школе QA.GURU и представляет из себя часть выпускной работы.

## Оглавление
+ [Стек проекта](#projectStack)
+ [Архитектура проекта](#projectArchitecture)
+ [Запуск тестов](#runningTests)
    + [Запуск тестов локально](#runningTestsLocal)
    + [Запуск тестов в Jenkins](#runningTestsJenkins)
+ [Результаты](#results)
  + [Allure отчет о прохождении тестов](#resultsAllure)
  + [Результаты тестирования в TMS](#resultInTms)
  + [Результаты в Jira](#resultsInJira)
  + [Сценарии тестирования в TMS](#testCaseInTms)
  + [Уведомления](#resultNotification)
  + [Видео прохождения тестов](#resultVideo)

    
<h2><a name='projectStack'>:iphone::Стек проекта:</a></h2>
<p align="center">
    <a href="#"><img title="Java" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/java.svg" width="30px"/></a>
    <a href="#"><img title="Gradle" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Gradle.svg" width="50px"/></a>
    <a href="#"><img title="JUnit5" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/JUnit5.svg" width="50px"/></a>
    <a href="#"><img title="Selenide" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Selenide.svg" width="50px"/></a>
    <a href="#"><img title="RestAssured" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Rest-Assured.svg" width="50px"/></a>
    <a href="#"><img title="Allure_Report" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Allure_Report.svg" width="50px"/></a>
    <a href="#"><img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Jenkins.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/AllureTestOps.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Browserstack.svg" width="50px"/></a>
    <a href="#"><img title="Allure Test Ops" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/logo/Appium.svg" width="50px"/></a>
</p>



<ul>
	<li>Java - используется как основной язык для написания тестов</li>
	<li>Gradle - используется для сборки проекта</li>
	<li>Junit5 - тестовый фремворк</li>
	<li>SelenideAppium - библиотека для работы с UI элементами приложения</li>
	<li>Allure - для формирования отчетов</li>
	<li>Jenkins - используется для запуска тестов</li>
	<li>Browserstack - используется для создания контейнеров для прохождения тестов</li>
	<li>AllureTestOps - система управления тестовыми сценариями</li>
</ul>



<h2>:iphone:<a name='projectArchitecture'>Архитектура проекта</a></h2>
Архитектура проекта состоит из 5 основных модулей
<ol>
    <li>
        <b>OwnerConfig</b> - конфигурационные файлы проекта, в которых может содержаться информация о среде выполнения теста и данные необходимые для работы теста.
        Данные для конфига берутся из .properties файла в ресурсах проекта, а так же из параметров запущенного теста.
    </li>
    <li>
        <b>BaseTest</b> - базовый класс с конфигурацией от которого наследуются все классы с тестами. Содержит методы BeforeEach и AfterEach.
    </li>
    <li>
        <b>Test</b> - класс описывающий логику работы теста основываясь на бизнесс требованиях.
    </li>
    <li>
        <b>PageObjects</b> - класс для описания страницы приложения. Поля класса объявляются как приватные константы и описывают селекторы для необходимых элементов.
        Взаимодействие с классом происходит за счет публичных методов класса, использующих ранее описанные селекторы.
    </li>
    <li>
        <b>PageElements</b> - класс для описания логики работы с часто используемыми элементами страницы. (ComboBox, Calendar...)
    </li>
</ol>

```mermaid
flowchart LR
    classDef class1 fill:#ffe0a1
    classDef class2 fill:#f3f76a
    classDef class3 fill:#feffd4
    
	A[Test]:::class1 -.Использует.-o B[PageObject]:::class2
	B -.Использует.-o C[PageElements]:::class3
	A -.Берет данные из.-x D[OwnerConfig]
	A --Наследуется от--> E[BaseTest]:::class1
	E -.Берет данные из.-x D
```

<h2>:iphone:<a name='runningTests'>Запуск тестов через Browserstack</a></h2>

Перед тем как запустить тесты в Browserstack нужно в нем зарегистрироваться и загрузить apk файл с приложением.
1) для регистрации нужно перейти по ссылке https://www.browserstack.com/users/sign_in
узнать логин и пароль для запуска тестов можно нажав на кнопку 'Access key'
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_3/Screenshot_4.png" />
</p>


2) загрузить приложение можно тут https://app-automate.browserstack.com/dashboard/v2/get-started#upload-app
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_3/Screenshot_3.png" />
</p>


<h3>:iphone:<a name='runningTestsLocal'>Запуск тестов локально</a></h3>

Для запуска тестов локально используется команда : <b>gradle clean regress</b>

<p><b>-Ddevice</b> - модель телефона на котором нужно запустить тесты</p>
<p><b>-DappId</b> - id приложения browserStack</p>

Для работы тестов подразумевающих авторизацию в системе нужно дополнительно указать параметры:
<p><b>-Dlogin</b> - логин для browserStack</p>
<p><b>-Dpassword</b> - пароль для browserStack</p>
<p>P.S. Либо прописать их в конфигурационном файле <b>resources/config/browserstack.properties</b></p>

Так же необходимо указать токен бота и чат в который должны приходить уведомление в телеграмм. Для этого нужно
отредактировать файл: <b>notifications/telegram.json</b>


<h3>:iphone:<a name='runningTestsJenkins'>Запуск тестов в Jenkins</a></h3>
В качестве CI для тестов используется Jenkins, запуск тестов осуществляется в контейнерах Selenoid.

Для запуска тестов нужно создать параметризованную сборку. 
<p>1. В качестве параметров были выбраны</p>
<p><b>-Ddevice</b> - модель телефона на котором нужно запустить тесты</p>
<p><b>-DappId</b> - id приложения browserStack</p>

<p>2. По результатам прохождения тестов формируются Allure отчет, а так же происходит интеграция результатов в TMS AllureTestOps</p>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_3/Screenshot_1.png" />
</p>

<h2>:iphone:<a name='results'>Результаты</a></h2>
<h3>:iphone:<a name='resultsAllure'>Allure отчет о прохождении тестов</a></h3>
На основе результатов тестов формируется красивый Allure отчет. По которому можно посмотреть как прошли тесты и быстро определить
где была ошибка в случае ее обнаружения.

<p align="center">
<img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_3/Screenshot_5.png" />
</p>

<h3>:iphone:<a name='resultsInTms'>Результаты в TSM</a></h3>
После прохождения тестов, результаты автоматически импортируются в TMS, где их может посмотреть любой участник команды.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/5.PNG" />
</p>

<h3>:iphone:<a name='resultsInJira'>Результаты в Jira</a></h3>
Результаты из TMS импортируются в задачу Jira
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/8.png" />
</p>

<h3>:iphone:<a name='testCaseInTms'>Сценарии тестирования в TMS</a></h3>
На осиное написанных тестов, в системе управления тестовыми сценариями автоматически были созданы тест кейсы для пройденных тестов.
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/6.PNG" />
</p>


<h3>:iphone:<a name='resultNotification'>Уведомления</a></h3>
Чтобы узнавать о результатах прохождения тестов, не обязательно постоянно следить за тестпланом в TMS или джобой в Jenkins.
В проекте настроены уведомления в телеграм, при помощи библиотеки <b>https://github.com/qa-guru/allure-notifications</b>

<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_1/7.PNG" />
</p>

<h3>:iphone:<a name='resultVideo'>Видео прохождения тестов</a></h3>
<p align="center">
    <img title="Jenkins" src="https://github.com/NikitaDanshin415/NikitaDanshin415/blob/main/diploma_3/848868182d66d878701aee934ac4072af6abec91.gif" />
</p>
