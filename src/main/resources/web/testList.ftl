<!DOCTYPE html>

<html>
    <body>
        <#list testList as entity >
            序号 ：${entity_index +1} &nbsp;&nbsp; id : ${entity.id} &nbsp;&nbsp; 姓名 ：${entity.name} <br>

        </#list>
    </body>
</html>