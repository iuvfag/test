document.write("問1");
document.write("<br>");
document.write("<br>");
for(a = 0; a <5; a++){
    document.write("★");
}

document.write("<br>");
document.write("<br>");
document.write("問2");
document.write("<br>");
document.write("<br>");
for(b = 0; b < 3; b++){
    for(bb = 0; bb < 3; bb++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問3");
document.write("<br>");
document.write("<br>");
for(c = 0; c < 2; c++){
    for(cc = 0; cc < 5; cc++){
        document.write("☆");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問4");
document.write("<br>");
document.write("<br>");
for(d = 0; d < 4; d++){
    for(dd = 0; dd < 5; dd++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問5");
document.write("<br>");
document.write("<br>");
for(e = 0; e < 4; e++){
    for(ee = 0; ee < 3; ee++){
        document.write("★");
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問6");
document.write("<br>");
document.write("<br>");
for(f = 0; f < 3; f++){
    for(ff = 0; ff < 3; ff++){
        if(ff % 2 == 0){
            document.write("★");
        }else{
            document.write("☆");
        }
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問7");
document.write("<br>");
document.write("<br>");
for(g = 0; g < 4; g++){
    for(gg = 0; gg < 5; gg++){
        if(gg % 2 == 0){
            document.write("★");
        }else{
            document.write("☆");
        }
    }
    document.write("<br>");
}

document.write("<br>");
document.write("<br>");
document.write("問8");
document.write("<br>");
document.write("<br>");

for(i = 0; i < 5; i++){
    for(n = 0; n <= i; n++){
    document.write("★");
    }
    document.write("<br>");
}