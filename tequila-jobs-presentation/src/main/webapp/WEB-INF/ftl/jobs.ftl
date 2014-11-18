<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Tequila Jobs</title>
    </head>
    <body>
        <h1>Job list:</h1>
        <ul>
            <#list jobs as job>
                <li>${job.title}</li>
            </#list>
        </ul>
    </body>
</html>