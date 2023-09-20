
let accountList = [];//account情報のList
let locationList = [];//table情報のList
let trophyList = [];//trophy情報のList
let groupId = document.getElementById("groupId");
let groupName = document.getElementById("groupName");

function list(){

		var jsonData = JSON.stringify(accountList);

		var xhr = new XMLHttpRequest();
	        xhr.open("POST", "/MinnadeOsoziChan/FirstAdminRegistServlet", true);
	        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	        xhr.send(jsonData);
}

// 行の削除※削除おかしい
function deleteRow(obj,list) {
    // 削除ボタンを押下された行を取得
    var tr = obj.parentNode.parentNode;
    // trのインデックスを取得して行を削除する
    tr.parentNode.deleteRow(tr.sectionRowIndex);
	//配列から削除※怪しい
	list.splice(tr.sectionRowIndex);
}

//input欄の入力を削除
function clear(form){
    form.reset();
}

//修正(初期登録画面)
function retouchList(list){
	//List内の情報を変更する
}

//修正(管理画面)
function groupRetouhchList(){
	//List内の情報を変更する（複数）
}

function accountDisplayList(list){
	//Listを表示する
	let accountTbody = document.querySelector("#accountList tbody");

	while (accountTbody.firstChild) {
	    accountTbody.removeChild(accountTbody.firstChild);
	}

	for(let i = 0; i < list.length; i++){

		//ｔｒ要素の作成
		var newRow = document.createElement("tr");

		//ｔｄ要素の作成・追加
		let td1 = document.createElement("td");
			td1.textContent = [i+1];
			newRow.appendChild(td1);
		let td2 = document.createElement("td");
			td2.textContent = list[i].userName;
			newRow.appendChild(td2);
		let td3 = document.createElement("td");
			td3.textContent = list[i].userPass;
			newRow.appendChild(td3);
		let td4 = document.createElement("td");
			td4.textContent = list[i].admin_flg;
			newRow.appendChild(td4);

		var deleteButton = document.createElement("button");
        deleteButton.textContent = "削除";
        deleteButton.addEventListener("click", function() {
			deleteRow(this,list);
			accountDisplayList(list);
		    });

		let td5 = document.createElement("td");
		td5.appendChild(deleteButton);
    	newRow.appendChild(td5);

		accountTbody.appendChild(newRow);
	}

}

function locationDisplayList(list){
		let charaList = [
	  ['/bath1_3.png', 'お風呂' ],
	  ['/cactus1_3.png', 'サボテン' ],
	  ['/cat1_3.png', '猫1'],
	  ['/cat2_3.png', '猫2'],
	  ['/cat3_3.png', '猫3'],
	  ['/flower1.png', '花'],
	  ['/plant1_3.png', '木'],
	  ['/poodle_3.png', '犬'],
	  ['/rabbit1_3.png', 'ウサギ']
	];

	    let roomPhotoList = [
	  ['/entrance1.jpg', '玄関' ],
	  ['/entrance2.jpg', '玄関2' ],
	  ['/entrance3.jpg', '玄関3'],
	  ['/kids1.jpg', '子供部屋1'],
	  ['/kids2.jpg', '子供部屋2'],
	  ['/kids3.jpg', '子供部屋3'],
	  ['/lady2.jpg', 'ベッドルーム'],
	  ['/lady1.jpg', 'リビング'],
	  ['/living1.jpg', 'リビング2'],
	  ['/living2.jpg', 'リビング3'],
	  ['/oneroom1.jpg', 'リビング4'],
	  ['/restroom1.jpg', 'トイレ'],
	  ['/restroom2.jpg', 'トイレ2']
	];
	//Listを表示する

	let locationTbody = document.querySelector("#locationList tbody");

	while (locationTbody.firstChild) {
	    locationTbody.removeChild(locationTbody.firstChild);
	}
	let j = 0;

	for(let i = 0; i < list.length; i++){

		//ｔｒ要素の作成
		var newRow = document.createElement("tr");

		//ｔｄ要素の作成・追加
		let td1 = document.createElement("td");
			td1.textContent = [i+1];
			newRow.appendChild(td1);
		let td2 = document.createElement("td");
			td2.textContent = list[i].locationName;
			newRow.appendChild(td2);
			let td3 = document.createElement("td");
			charaUrl = list[i].characterName;

		for (j = 0; j < charaList.length; j++) {
    		if (charaList[j][0] === charaUrl) {
			td3.textContent = charaList[j][1];
			newRow.appendChild(td3);
			break; //一致するURLが見つかったらループを終了
    }
}
			roomUrl = list[i].roomPhoto;

		for (j = 0; j < roomPhotoList.length; j++) {
    		if (roomPhotoList[j][0] === roomUrl) {
			td3.textContent = roomPhotoList[j][1];
			newRow.appendChild(td3);
			break; //一致するURLが見つかったらループを終了
    }
}
		let td5 = document.createElement("td");
			td5.textContent = list[i].frequency+"日間";
			newRow.appendChild(td5);
		let td6 = document.createElement("td");
			td6.textContent = list[i].setPoint+"pt";
			newRow.appendChild(td6);


		var deleteButton = document.createElement("button");
        deleteButton.textContent = "削除";
        deleteButton.addEventListener("click", function() {
			deleteRow(this,list);
			locationDisplayList(list);
		    });

		let td7 = document.createElement("td");
		td7.appendChild(deleteButton);
    	newRow.appendChild(td7);

		locationTbody.appendChild(newRow);
	}

}

function trophyDisplayList(list){
	//Listを表示する
	let trophyTbody = document.querySelector("#trophyList tbody");

	while (trophyTbody.firstChild) {
	    trophyTbody.removeChild(trophyTbody.firstChild);
	}

	for(let i = 0; i < list.length; i++){

		//ｔｒ要素の作成
		var newRow = document.createElement("tr");

		//ｔｄ要素の作成・追加
		let td1 = document.createElement("td");
			td1.textContent = [i+1];
			newRow.appendChild(td1);
		let td2 = document.createElement("td");
			td2.textContent = list[i].details;
			newRow.appendChild(td2);
		let td3 = document.createElement("td");
			td3.textContent = list[i].needpoint;
			newRow.appendChild(td3);

		var deleteButton = document.createElement("button");
        deleteButton.textContent = "削除";
        deleteButton.addEventListener("click", function() {
			deleteRow(this,list);
			trophyDisplayList(list);
		    });

		let td4 = document.createElement("td");
		td4.appendChild(deleteButton);
    	newRow.appendChild(td4);

		trophyTbody.appendChild(newRow);
	}

}

function createAccountList(){
	//.jspから入力情報を取得
	//List化

	let userName = document.querySelector('input[name="userName"]').value;
	let userPass = document.querySelector('input[name="userPass"]').value;
	let admin_flg = document.querySelector('[name="admin_flg"]:checked').value;

	let account = {
		userName: userName,
		userPass: userPass,
		admin_flg: admin_flg
	}

	accountList.push(account);

	accountDisplayList(accountList);

	let form = document.getElementById("accountform");

	clear(form);

}

function createLocationList(){
	//.jspから入力情報を取得
	//List化

	let locationName = document.querySelector('input[name="locationName"]').value;
	let characterName = document.querySelector('[name="characterName"]').value;
	let roomPhoto = document.querySelector('[name="roomPhoto"]').value;
	let frequency = document.querySelector('[name="frequency"]').value;
	let setPoint = document.querySelector('[name="setPoint"]').value;

	let location = {
		locationName:locationName,
		characterName:characterName,
		roomPhoto:roomPhoto,
		frequency:frequency,
		setPoint:setPoint
	}

	locationList.push(location);

	locationDisplayList(locationList);

	let form = document.getElementById("locationform");

	clear(form);

}

function createTrophyList(){
	//.jspから入力情報を取得
	//List化

	let details = document.querySelector('input[name="details"]').value;
	let needpoint = document.querySelector('[name="needpoint"]').value;

	let trophy = {
		details:details,
		needpoint:needpoint
	}

	trophyList.push(trophy);

	trophyDisplayList(trophyList);

	let form = document.getElementById("trophyform");

	clear(form);


}
