<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>4eachblog　掲示板</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
    
        <img src="4eachblog_logo.jpg">
        <header>
            <ul>
                <li>トップ</li>
                <li>プロフィール</li>
                <li>4eachについて</li>
                <li>登録フォーム</li>
                <li>問い合わせ</li>
                <li>その他</li>
            </ul>
        </header>
        
        <main>
            <div class="main_container">
                <div class="left">
                    <h1>プログラミングに役立つ掲示板</h1>
                    
                        <form method="post" action="insert.php">
                            <h2>入力フォーム</h2>
                            <div>
                                <label>ハンドルネーム</label><br>
                                <input type="text" size="35" name="handlename">
                            </div>
                            
                            <div>
                                <label>タイトル</label><br>
                                <input type="text" size="35" name="title">
                            </div>
                            
                            <div>
                                <label>コメント</label><br>
                                <textarea name="comments" rows="7" cols="50"></textarea>
                            </div>
                            
                            <div>
                                <input type="submit" name="submit" value="送信する">
                            </div>
                            
                        </form><br><br>
                        
                    <h2>タイトル</h2>
                    
                    <h2>タイトル</h2>
                </div>
                
                <div class="right">
                    <h2>人気の記事</h2>
                        <p>
                            PHPオススメ本<br>
                            PHP　MyAdminの使い方<br>
                            今人気のエディタtop5<br>
                            HTMLの基礎<br>
                        </p>
                    <h2>オススメリンク</h2>
                        <p>
                            インターノウス株式会社<br>
                            XAMPPのダウンロード<br>
                            Eclipseのダウンロード<br>
                            Bracketsのダウンロード<br>
                        </p>
                    <h2>カテゴリ</h2>
                        <p>
                            HTML<br>
                            PHP<br>
                            MｙSQL<br>
                            JavaScript<br>
                        </p>
                
                </div>
            
            </div>
        </main>
        
        <footer>
            copyright internous | 4each blog is the one which provides A to Z about programming
        </footer>
    
    </body>
</html>