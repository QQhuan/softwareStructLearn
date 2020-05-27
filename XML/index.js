$(function(){
    
    $("#submit").click(function(){
        let id = $("#id").val();
        let name = $("#name").val();

        if (window.XMLHttpRequest)
            {   // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {   // code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.open("GET","test.xml",false);
            xmlhttp.send();
            xmlDoc=xmlhttp.responseXML;
            var books = xmlDoc.getElementsByTagName("root");
            for(var i=0;i<books.length;i++){
                let s = xmlDoc.createElement("student");
                let Id = xmlDoc.createElement(id);
                let Name = xmlDoc.createElement(name);
                id = xmlDoc.createTextNode(id);
                Name = xmlDoc.createTextNode(name);
                s.appendChild(Id);
                s.appendChild(Name);
                books[i].appendChild(s);
            }
            console.log(xmlDoc.childNodes[0]);
        
        if (window.XMLHttpRequest)
            {   // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlhttp=new XMLHttpRequest();
            }
            else
            {   // code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.open("GET","test.xml",false);
            xmlhttp.send();
            xmlDoc=xmlhttp.responseXML;
            var names = xmlDoc.getElementsByTagName("student");
            //将文件内容输出到浏览器上
            for(var i=0;i<names.length;i++){
                document.write("<div>");
                document.write("学号：");
                document.write(names[i].getElementsByTagName("id")[0].childNodes[0].nodeValue);
                document.write("姓名：");
                document.write(names[i].getElementsByTagName("name")[0].childNodes[0].nodeValue);
                document.write("</div>");
            }
    });


    function loadXMLDoc(file) 
    {
                try //Internet Explorer  
        {  
        xmlDoc=new ActiveXObject("Microsoft.XMLDOM");  
        xmlDoc.async=false;  
        xmlDoc.load(file);  
        return xmlDoc;
        }  
        catch(e)  
        {  
        try //Firefox, Mozilla, Opera, etc.  
        {  
        xmlDoc=document.implementation.createDocument("","",null);  
        xmlDoc.async=false;  
        xmlDoc.load(file);  
        return xmlDoc;
        }  
        catch(e)  
        {  
        try //Google Chrome  
        {  
        var xmlhttp = new window.XMLHttpRequest();  
        xmlhttp.open("GET",file,false);  
        xmlhttp.send(null);  
        xmlDoc = xmlhttp.responseXML.documentElement;  
        return xmlDoc;
        }  
        catch(e)  
        {  
        error=e.message;  
        }  
        }  
        }  
    }
    //读取XML文件
    function loadXML(path, id, name){
        $.ajax({
            url: "test.xml",
            dataType: 'xml',
            type: 'GET',
            timeout: 2000,
            error: function(xml)
            {
                alert("加载XML 文件出错！");
            },
            success: function(xml)
            {
                $(xml).find("student").each(function(i, x)
                { 
                    var id = $(x).children("id").text();
                    var name = $(x).children("name").text();
                    console.log(id+name)
                });
                
            }
        });
    }
});