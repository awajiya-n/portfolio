//Player1のステータス変数
let p1hp = 50;
let p1mp = 15;
let p1pw = 5;
let p1df = 0;
let p1hpp = 3;
let p1mpp = 2;
let p1dfp = 1;
let p1pwp = 1;

//Player2のステータス変数
let p2hp = 50;
let p2mp = 15;
let p2pw = 5;
let p2df = 0;
let p2hpp = 4;
let p2mpp = 2;
let p2dfp = 1;
let p2pwp = 1;

//ターン情報変数
let turn = 1;

//Player1 のコマンド

// Player1 の攻撃
function attack1() {
    gameover();
    // 攻撃の効果計算方法
    let totalAttack = Math.floor(Math.random() * 3) + p1pw - p2df;
    if (totalAttack < 0) {
        totalAttack = 0;
    }
    p2hp -= totalAttack;
    if (p2hp <= 0) {
        p2hp = 0;
    } else {
        showTurn("attack", "2", totalAttack);
        nextTurn();
    }
}

// Player1 の魔法
function magic1(select) {
    if (select == "fire") {
        gameover();
        if (p1mp < 3) {
            showTurn("lessMp", "1", "");
            // nextTurn();
        } else {
            // ファイヤーの効果計算方法
            let fireAttack = Math.floor(Math.random() * 15) + 1
            p1mp -= 3;
            p2hp -= fireAttack;
            if (p2hp <= 0) {
                p2hp = 0;
            } else {
                showTurn("attack", "2", fireAttack);
                nextTurn();
            }
        }

    } else if (select == "ice") {
        gameover();
        if (p1mp < 5) {
            showTurn("lessMp", "1", "");
            // nextTurn();
        } else {
            // アイスの効果計算方法
            let iceAttack = Math.floor(Math.random() * 18) + 3;
            p1mp -= 5;
            p2hp -= iceAttack
            if (p2hp <= 0) {
                p2hp = 0;
            } else {
                showTurn("attack", "2", iceAttack);
                nextTurn();
            }
        }

    } else if (select == "heal") {
        gameover();
        if (p1mp < 2) {
            showTurn("lessMp", "1", "");
            // nextTurn();
        } else {
            // ヒールの効果計算方法
            let healPoint = Math.floor(Math.random() * 11) + 5;
            p1mp -= 2;
            p1hp += healPoint;
            if (p1hp > 50) {
                p1hp = 50;
            }
            showTurn("healHp", "1", healPoint);
            nextTurn();
        }
    }
}

// Player1 の道具
function item1(select) {
    if (select == "HpPotion") {
        gameover();
        if (p1hpp == 0) {
            showTurn("lessPotion", "1", "HPポーション");
            // nextTurn();
        } else {
            // HPポーションの効果計算方法
            let hpPotion = Math.floor(Math.random() * 5) + 8;
            p1hp += hpPotion;
            if (p1hp > 50) {
                p1hp = 50;
            }
            p1hpp -= 1;
            showTurn("healHp", "1", hpPotion);
            nextTurn();
        }

    } else if (select == "MpPotion") {
        gameover();
        if (p1mpp == 0) {
            showTurn("lessPotion", "1", "MPポーション");
            // nextTurn();
        } else {
            // MPポーションの効果計算方法
            let mpPotion = Math.floor(Math.random() * 6) + 3;
            p1mp += mpPotion;
            if (p1mp > 15) {
                p1hp = 15;
            }
            p1mpp -= 1;
            showTurn("healMp", "1", mpPotion);
            nextTurn();
        }

    } else if (select == "PowerPotion") {
        gameover();
        if (p1pwp == 0) {
            showTurn("lessPotion", "1", "筋力ポーション");
            // nextTurn()
        } else {
            // 筋力ポーションの効果計算方法
            let powerPotion = Math.floor(Math.random() * 3) + 3;
            p1pw += powerPotion;
            if (p1pw > 10) {
                p1pw = 10;
            }
            p1pwp -= 1;
            showTurn("upPw", "1", powerPotion);
            nextTurn();
        }
    }

    else if (select == "StonePotion") {
        gameover();
        if (p1dfp == 0) {
            showTurn("lessPotion", "1", "硬化ポーション");
            // nextTurn()
        } else {
            // 硬化ポーションの効果計算方法
            let stonePotion = Math.floor(Math.random() * 5) + 1;
            p1df += stonePotion;
            if (p1df > 5) {
                p1df = 5;
            }
            p1dfp -= 1;
            showTurn("upDf", "1", stonePotion);
            nextTurn();
        }
    }
}

//Player2 のコマンド

//Player2 の攻撃
function attack2() {
    gameover();
    // 攻撃の効果計算方法
    let totalAttack = Math.floor(Math.random() * 3) + p1pw - p1df;
    if (totalAttack < 0) {
        totalAttack = 0;
    }
    p1hp -= totalAttack;
    if (p1hp <= 0) {
        p1hp = 0;
    } else {
        showTurn("attack", "1", totalAttack);
        nextTurn();
    }
}

// Player2 の魔法
function magic2(select) {
    if (select == "fire") {
        gameover();
        if (p2mp < 3) {
            showTurn("lessMp", "2", "");
            // nextTurn();
        } else {
            // ファイヤーの効果計算方法
            let fireAttack = Math.floor(Math.random() * 15) + 1
            p2mp -= 3;
            p1hp -= fireAttack;
            if (p1hp <= 0) {
                p1hp = 0;
            } else {
                showTurn("attack", "1", fireAttack);
                nextTurn();
            }
        }

    } else if (select == "ice") {
        gameover();
        if (p2mp < 5) {
            showTurn("lessMp", "2", "");
            // nextTurn();
        } else {
            // アイスの効果計算方法
            let iceAttack = Math.floor(Math.random() * 18) + 3;
            p2mp -= 5;
            p1hp -= iceAttack
            if (p1hp <= 0) {
                p1hp = 0;
            } else {
                showTurn("attack", "1", iceAttack);
                nextTurn();
            }
        }

    } else if (select == "heal") {
        gameover();
        if (p2mp < 2) {
            showTurn("lessMp", "2", "");
            // nextTurn();
        } else {
            // ヒールの効果計算方法
            let healPoint = Math.floor(Math.random() * 11) + 5;
            p2mp -= 2;
            p2hp += healPoint;
            if (p2hp > 50) {
                p2hp = 50;
            }
            showTurn("healHp", "2", healPoint);
            nextTurn();
        }
    }
}

// Player2 の道具
function item2(select) {
    if (select == "HpPotion") {
        gameover();
        if (p2hpp == 0) {
            showTurn("lessPotion", "2", "HPポーション");
            // nextTurn();
        } else {
            // HPポーションの効果計算方法
            let hpPotion = Math.floor(Math.random() * 5) + 8;
            p2hp += hpPotion;
            if (p2hp > 50) {
                p2hp = 50;
            }
            p2hpp -= 1;
            showTurn("healHp", "2", hpPotion);
            nextTurn();
        }

    } else if (select == "MpPotion") {
        gameover();
        if (p2mpp == 0) {
            showTurn("lessPotion", "2", "");
            // nextTurn();
        } else {
            // MPポーションの効果計算方法
            let mpPotion = Math.floor(Math.random() * 6) + 3;
            p2mp += mpPotion;
            if (p2mp > 15) {
                p2mp = 15;
            }
            p2mpp -= 1;
            showTurn("healMp", "2", mpPotion);
            nextTurn();
        }

    } else if (select == "PowerPotion") {
        gameover();
        if (p2pwp == 0) {
            showTurn("lessPotion", "2", "");
            // nextTurn()
        } else {
            // 筋力ポーションの効果計算方法
            let powerPotion = Math.floor(Math.random() * 3) + 3;
            p2pw += powerPotion;
            if (p2pw > 10) {
                p2pw = 10;
            }
            p2pwp -= 1;
            showTurn("upPw", "2", powerPotion);
            nextTurn();
        }

    } else if (select == "StonePotion") {
        gameover();
        if (p2dfp == 0) {
            showTurn("lessPotion", "2", "");
            // nextTurn();
        } else {
            // 硬化ポーションの効果計算方法
            let stonePotion = Math.floor(Math.random() * 5) + 1;
            p2df += stonePotion;
            if (p2df > 5) {
                p2df = 5;
            }
            p2dfp -= 1;
            showTurn("upDf", "2", stonePotion);
            nextTurn();
        }
    }
}


// ステータス表示関数
function showStatus() {
    // Player1
    // HP
    document.getElementById("player1hp").value = p1hp;
    if (p1hp <= 0) {
        document.getElementById("player1hp").style.backgroundColor = "lightcoral";
    } else if (p1hp <= 15) {
        document.getElementById("player1hp").style.backgroundColor = "lightyellow";
    } else {
        document.getElementById("player1hp").style.backgroundColor = "";
    }
    // MP
    document.getElementById("player1mp").value = p1mp;
    if (p1mp <= 5) {
        document.getElementById("player1mp").style.backgroundColor = "lightyellow";
    } else {
        document.getElementById("player1mp").style.backgroundColor = "";
    }
    // 攻撃力
    document.getElementById("player1pw").value = p1pw;
    // 防御力
    document.getElementById("player1df").value = p1df;

    // Player2
    // HP
    document.getElementById("player2hp").value = p2hp;
    if (p2hp <= 0) {
        document.getElementById("player2hp").style.backgroundColor = "lightcoral";
    } else if (p2hp <= 15) {
        document.getElementById("player2hp").style.backgroundColor = "lightyellow";
    } else {
        document.getElementById("player2hp").style.backgroundColor = "";
    }
    // MP
    document.getElementById("player2mp").value = p2mp;
    if (p2mp <= 5) {
        document.getElementById("player2mp").style.backgroundColor = "lightyellow";
    } else {
        document.getElementById("player2mp").style.backgroundColor = "";
    }
    // 攻撃力
    document.getElementById("player2pw").value = p2pw;
    // 防御力
    document.getElementById("player2df").value = p2df;
}

//ポーション数表示関数
function showPotion() {
    document.getElementById("p1hpp").value = p1hpp;
    document.getElementById("p1mpp").value = p1mpp;
    document.getElementById("p1dfp").value = p1dfp;
    document.getElementById("p1pwp").value = p1pwp;

    document.getElementById("p2hpp").value = p2hpp;
    document.getElementById("p2mpp").value = p2mpp;
    document.getElementById("p2dfp").value = p2dfp;
    document.getElementById("p2pwp").value = p2pwp;
}

//ターン情報表示関数
function showInfo() {
    if (p1hp != 0 && p2hp != 0) {
        document.getElementById("info").value = "現在 " + turn + "ターン目  PLAYER " + ((turn + 1) % 2 + 1) + "のターンです";
        if (turn % 2 == 0) {
            document.getElementById("info").style.color = "blue";
        } else if (turn % 2 == 1) {
            document.getElementById("info").style.color = "red";
        }
    } else {
        if (p1hp == 0) {
            document.getElementById("info").value = "PLAYER 2の勝利！";
            document.getElementById("info").style.color = "blue";
            document.getElementById("turn").value = "";
        } else if (p2hp == 0) {
            document.getElementById("info").value = "PLAYER 1の勝利！";
            document.getElementById("info").style.color = "red";
            document.getElementById("turn").value = "";
        }
    }
}

//実行結果表示
function showTurn(action, player, point) {
    if (action == "attack") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " に" + point + "のダメージ！";
    } else if (action == "healHp") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " のHPが" + point + "回復した！";
    } else if (action == "healMp") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " のMPが" + point + "回復した！";
    } else if (action == "upPw") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " の攻撃力が" + point + "上昇した！";
    } else if (action == "upDf") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " の防御力が" + point + "上昇した！";
    } else if (action == "lessMp") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " のMPが足りない！";
    } else if (action == "lessPotion") {
        document.getElementById("turn").value = "第" + turn + "ターン結果：PLAYER " + player + " の" + point + "は残っていない！";
    }
}

// ターン管理関数
function nextTurn() {
    turn++;
}

// 説明画面管理
function examOpen() {
    window.open("exam.html", "説明", "width=560,height=750");
}

// 画面再表示制御
function reload() {
    document.location.reload();
}

// ゲームオーバー制御
function gameover() {
    if (p1hp == 0 || p2hp == 0) {
        return;
    }
}

//以下は試行錯誤の破片

// function damegeForPlayer1(attack) {
//     let totalDamage = attack - p1df;
//     p1hp -= totalDamage;
// }

// function damegeForPlayer2(attack) {
//     let totalDamage = attack - p2df;
//     p2hp -= totalDamage;
// }
// function showStatus(){
// let del = document.getElementById("del");
// del.remove();
//     document.clear
//     document.write('<h3>勇者</h3><p>残りHP:<script>document.write(hero.hp)</script></p><p>残りMP:<script>document.write(hero.mp)</script></p><h3>モンスター</h3><p>残りHP:<script>document.write(monster.hp)</script></p>');
// }

