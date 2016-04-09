function PNode(node, nodeId, nodeMessage) {
	this.node = node;
	this.nodeId = nodeId;
	this.nodeMessage = nodeMessage;
}

var nodeList = new Array();

function getNode(id) {
	for ( var i = 0; i < nodeList.length; i++) {
		if (nodeList[i].nodeId == id)
			return nodeList[i];
	}
	return null;
}

function saveNode(node) {
	nodeList[nodeList.length] = node;
}

var canvas = document.getElementById('canvas');
var stage = new JTopo.Stage(canvas);
scene = new JTopo.Scene(stage);
scene.setBackground('./img/bg.jpg');

scene.addEventListener('mouseup', function(e) {
	if (e.target && e.target.layout) {
		scene.layoutNode(e.target);
	}
});

var selectedNodeId = "00";

scene.addEventListener('click', function(e) {
	var nodeId = e.target.nodeId;
	selectedNodeId = nodeId;
	var pNode = getNode(nodeId);
	showNodeMessage(pNode);
});

scene.addEventListener('dbclick', function(e) {
	var nodeId = e.target.nodeId;
	selectedNodeId = nodeId;
	var pNode = getNode(nodeId);
	changeRootNode(pNode);
	showNodeMessage(pNode);
});

function showNodeMessage(pNode) {
	var isException = pNode.nodeMessage.isException;
	if (isException != 0) {
		$(".isException").text("异常").css("color", "red");
	} else {
		$(".isException").text("正常").css("color", "black");
	}
	$(".exceptionDescription").text(pNode.nodeMessage.exceptionDescription);
	$(".ipAddr").text(pNode.nodeMessage.nodeIp);
	$(".nodeName").text(pNode.nodeMessage.nodeName);
	$(".subType").text(pNode.nodeMessage.subType);
	$(".protocolTypes").text(pNode.nodeMessage.protocolTypes);
	$(".devVendor").text(pNode.nodeMessage.devVendor);
	$(".devModel").text(pNode.nodeMessage.devModel);
	$(".createTime").text(pNode.nodeMessage.createTime);
	$(".updateTime").text(pNode.nodeMessage.updateTime);
	$(".lastDisTime").text(pNode.nodeMessage.lastDisTime);
}

function changeRootNode(pNode) {
	$("#nodeIp").val(pNode.nodeMessage.nodeIp);
}

function nodeMessage(nodeAttributes) {
	// nodeAttributes
	// 1:状态
	// 2:状态
	this.isException = nodeAttributes[0];
	this.exceptionDescription = nodeAttributes[1];
	this.nodeIp = nodeAttributes[2];
	this.nodeName = nodeAttributes[3];
	this.subType = nodeAttributes[4];
	this.protocolTypes = nodeAttributes[5];
	this.devVendor = nodeAttributes[6];
	this.devModel = nodeAttributes[7];
	this.createTime = nodeAttributes[8];
	this.updateTime = nodeAttributes[9];
	this.lastDisTime = nodeAttributes[10];
}

function run(message) {
	nodeList.length = 0;
	scene.clear();
	if (message == null || message.length < 1)
		return;
	var messages = message.split("\n");

	var cloudNodes = messages[0].split("@@@@@@@");
	var cloudNodeAttributes = cloudNodes[1].split("@_@");

	var cloudNode = new JTopo.Node(cloudNodeAttributes[2]);

	cloudNode.setLocation(scene.width / 2,50);
	cloudNode.style.fontColor = "0,0,0";
	/*cloudNode.layout = {
		type : 'star',
		radius : 170,
		beginDegree : 0,
		endDegree : 2 * Math.PI
	};*/
	cloudNode.layout = {
			type: 'tree', width: 110, height: 100, direction:'bottom'
		};

	var cloudpNode = new PNode(cloudNode, cloudNodes[0], new nodeMessage(
			cloudNodeAttributes));
	if(cloudpNode.nodeMessage.isException == 0){
		 cloudNode.setImage('topo/img/host.png');
		}else{
		 cloudNode.setImage('topo/img/host_exception.png');
		}
	scene.add(cloudNode);
	saveNode(cloudpNode);

	for ( var i = 1; i < messages.length; i++) {
		var nodes = messages[i].split("@@@@@@@");
		if (nodes.length < 2) {
			continue;
		}
		var nodeAttributes = nodes[1].split("@_@");
		/*
		 * var nodeState = nodeAttributes[0]; var nodeStateDescription =
		 * nodeAttributes[1];
		 */
		var node = new JTopo.Node(nodeAttributes[2]);
		node.nodeId = nodes[0];
		var pNode = new PNode(node, nodes[0], new nodeMessage(nodeAttributes));

		// pNode.id = arrts[1];
		saveNode(pNode);
		node.style.fontColor = "0,0,0";
		if (pNode.nodeMessage.isException == 0) {
			node.setImage('topo/img/host.png');
		} else {
			node.setImage('topo/img/host_exception.png');
		}
		node.setLocation(scene.width * Math.random(), scene.height
				* Math.random());
		// node.setLocation(scene.width, scene.height);
		/*node.layout = {
			type : 'star',
			radius : 170
		};*/
		node.layout = {
				type: 'tree', width: 110, height: 100, direction:'bottom'
			};
		
		scene.add(node);
		var nodestart = nodes[0].substr(0, nodes[0].length - 2);
		var link = new JTopo.Link(getNode(nodestart).node,
				getNode(nodes[0]).node);
		scene.add(link);

	}
	scene.layoutNode(cloudNode);

	stage.play(scene);
	var test=selectedNodeId;
	showNodeMessage(getNode(selectedNodeId));

}

var Chat = {};

Chat.socket = null;

Chat.connect = (function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		Chat.socket = new MozWebSocket(host);
	} else {
		alert("error");
		return;
	}

	Chat.socket.onopen = function() {
		// Chat.socket.send('begin');

		$("#begin").click(function() {
					// alert("Chat.socket.send('begin');");
				/*	var nodeId = e.target.nodeId;
					$("#nodeIp").val(pNode.nodeMessage.nodeIp);*/
			        selectedNodeId = "00";
					var nodeIp = $("#nodeIp").val();
					var level = $("#level").val();
					var direction = $("#direction").val();
					var period = $("#period").val();
					if (nodeIp == "") {
						Chat.socket.send('begin');
					} else {
						// Chat.socket.send("check_ip="+nodeIp+"_level="+level);
						Chat.socket.send('stop');
						Chat.socket.send("check_" + nodeIp + "_" + level + "_"
								+ direction + "_" + period);
					}
				});

		$("#stop").click(function() {
			// alert("Chat.socket.send('stop');");
			Chat.socket.send('stop');
			/*
			 * $("#begin").show(); $("#stop").hide();
			 */
		});
	};

	Chat.socket.onclose = function() {
		alert("Chat.socket.onclose");
	};

	Chat.socket.onmessage = function(message) {

		Console.receiveMessage(message.data);
	};
});

Chat.initialize = function() {
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + '/ENAS1/websocket/chat');
	} else {
		Chat.connect('wss://' + window.location.host + '/ENAS1/websocket/chat');
	}
};

var Console = {};

Console.receiveMessage = (function(message) {

	run(message);
});

Chat.initialize();