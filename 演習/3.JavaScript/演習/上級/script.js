document.write("問1");
document.write("<br>");
document.write("<br>");

for(a = 0; a < 5; a++){
    for(aa = 0; aa <5; aa++){
        document.write("★");
    }
    document.write("<br>");
}


document.write("<br>");
document.write("<br>");
document.write("問2");
document.write("<br>");
document.write("<br>");

for(b = 0; b < 5; b++){
    if(b % 2 ==1){
        for(bb = 0; bb < 5; bb++){
            if(bb % 2 == 0){
                document.write("★");
            }else{
                document.write("☆");
            }
        }
        
    }
    else if(b % 2 == 0){
        for(bbb = 0; bbb < 5; bbb++){
            if(bbb % 2 == 0){
                document.write("☆");
            }else{
                document.write("★");
            }
        }
    }
    document.write("<br>");
    }


document.write("<br>");
document.write("<br>");
document.write("問3");
document.write("<br>");
document.write("<br>");
for(c = 0; c < 5; c++){
    for(cc = 0; cc < 5 ; cc++){
        if(cc == c){
            document.write("☆");
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}



document.write("<br>");
document.write("<br>");
document.write("問4");
document.write("<br>");
document.write("<br>");
for(d = 1; d <= 5; d++){
    for(dd = 1; dd <= d; dd++){
        document.write("★");
    }
    document.write("<br>");
}


document.write("<br>");
document.write("<br>");
document.write("問5");
document.write("<br>");
document.write("<br>");
for(e = 1; e <= 5; e++){
    for(ee = 1; ee <= e; ee++){
        if(ee == e){
            document.write("☆");
        }else{
            document.write("★");
        }
    }
    document.write("<br>");
}