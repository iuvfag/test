document.write("問1");
document.write("<br>");
document.write("<br>");
function menseki(radius, pai = 3.14){
    return radius * radius * pai;
}

document.write("半径5cmの円の面積は、");
document.write(menseki(5) + "cm2" + "<br>");
document.write("半径7cmの円の面積は、");
document.write(menseki(7) + "cm2" + "<br>");
document.write("半径10cmの円の面積は、");
document.write(menseki(10) + "cm2" + "<br>");


document.write("<br>");
document.write("<br>");
document.write("問2");
document.write("<br>");
document.write("<br>");
function totalPrice(aN, cN){
    return (500 * aN) + (200 * cN);
}

document.write("Aグループの合計金額は、");
document.write(totalPrice(2,4) + "円です。" + "<br>");
document.write("Bグループの合計金額は、");
document.write(totalPrice(1,5) + "円です。" +　"<br>");
document.write("Cグループの合計金額は、");
document.write(totalPrice(3,7) + "円です。" +　"<br>");