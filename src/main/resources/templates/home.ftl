<html>
<body>

<h1>Lista rzeczy do zrobienia:</h1>

<table>
    <thead>
        <tr>
            <th>#</th>
            <th>Do zrobienia</th>
            <th>Status</th>
            <th>Akcje</th>
        </tr>
    </thead>
    <tbody>
        <#list todos as todo>
        <tr>
            <td>${todo.id}</td>
            <td>${todo.title}</td>
            <td>${(todo.status)?string("ukończone", "w trakcie")}</td>
            <td><#if todo.status>V<#else><a href="ukonczono?id=${todo.id}">V</a></#if> | <a href="usun?id=${todo.id}">X</a></td>
        </tr>
        <#else>
        <tr>
            <td colspan="4">Brak zadań! :)<td>
        </tr>
        </#list>
    </tbody>
</table>

<a href="/dodaj"><button>Dodaj zadanie</button></a>

</body>
</html>