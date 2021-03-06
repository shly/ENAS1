(function(a) {
	JTopo = {
		version : "0.3.2"
	};
	a.JTopo = JTopo
})(window);
(function(j) {
	function b(l) {
		var k = this;
		this.name = l;
		this.messageMap = {};
		this.messageCount = 0;
		this.subscribe = function(n, o) {
			if (!typeof n == "string") {
				m(n, o)
			} else {
				var p = k.messageMap[n];
				if (p == null) {
					k.messageMap[n] = []
				}
				k.messageMap[n].push(o);
				k.messageCount++
			}
		};
		function m(u, s) {
			var q = [];
			var n = 0;
			for ( var p = 0; p < u.length; p++) {
				var o = u[p];
				var t = k.messageMap[o];
				if (t == null) {
					k.messageMap[o] = []
				}
				function r(v) {
					q[p] = v;
					n++;
					if (n == u.length) {
						n = 0;
						return s.apply(null, q)
					} else {
						return null
					}
				}
				k.messageMap[o].push(r);
				k.messageCount++
			}
		}
		this.unsubscribe = function(n) {
			var o = k.messageMap[n];
			if (o != null) {
				k.messageMap[n] = null;
				delete (k.messageMap[n]);
				k.messageCount--
			}
		};
		this.publish = function(n, q, p) {
			var r = k.messageMap[n];
			if (r != null) {
				for ( var o = 0; o < r.length; o++) {
					if (p) {
						(function(t, s) {
							setTimeout(function() {
								t(s)
							}, 10)
						})(r[o], q)
					} else {
						r[o](q)
					}
				}
			}
		}
	}
	function e(n, m) {
		var l = m.x - n.x;
		var k = m.y - n.y;
		return Math.sqrt(l * l + k * k)
	}
	Array.prototype.del = function(l) {
		if (typeof l != "number") {
			for ( var k = 0; k < this.length; k++) {
				if (this[k] === l) {
					return this.slice(0, k).concat(
							this.slice(k + 1, this.length))
				}
			}
			return this
		} else {
			if (l < 0) {
				return this
			}
			return this.slice(0, l).concat(this.slice(l + 1, this.length))
		}
	};
	if (![].indexOf) {
		Array.prototype.indexOf = function(l) {
			for ( var k = 0; k < this.length; k++) {
				if (this[k] === l) {
					return k
				}
			}
			return -1
		}
	}
	if (!window.console) {
		window.console = {
			log : function(k) {
			},
			info : function(k) {
			},
			debug : function(k) {
			},
			warn : function(k) {
			},
			error : function(k) {
			}
		}
	}
	function h(k) {
		if (k.pageX || k.pageY) {
			return {
				x : k.pageX,
				y : k.pageY
			}
		}
		return {
			x : k.clientX + document.body.scrollLeft - document.body.clientLeft,
			y : k.clientY + document.body.scrollTop - document.body.clientTop
		}
	}
	function c(l) {
		l = l || h(window.event);
		var k = document.body.scrollLeft + (l.x || l.layerX);
		var m = document.body.scrollTop + (l.y || l.layerY);
		return {
			x : k,
			y : m
		}
	}
	function i(n, m, q, o, l) {
		var t = q - n;
		var s = o - m;
		var k = Math.sqrt(t * t + s * s);
		var p = Math.atan2(s, t) + l;
		return {
			x : n + Math.cos(p) * k,
			y : m + Math.sin(p) * k
		}
	}
	function d(o, m, q) {
		var k = [];
		for ( var l = 0; l < m.length; l++) {
			var n = i(o.x, o.y, m[l].x, m[l].y, q);
			k.push(n)
		}
		return k
	}
	function g(l, o, m) {
		if (l.length == 0) {
			return
		}
		var p = 0;
		function k(q) {
			if (q == l.length) {
				return
			}
			o(l[q]);
			setTimeout(function() {
				k(++q)
			}, m)
		}
		k(p)
	}
	function a(o, l, q, p) {
		if (l < o) {
			return
		}
		var r = 0;
		function k(m) {
			if (m == l) {
				return
			}
			q(l);
			setTimeout(function() {
				k(++m)
			}, p)
		}
		k(r)
	}
	function f(m) {
		var k = {};
		for ( var l in m) {
			k[l] = m[l]
		}
		return k
	}
	j.util = {
		rotatePoint : i,
		rotatePoints : d,
		getDistance : e,
		getXY : c,
		mouseCoords : h,
		MessageBus : b,
		isIE : (!+[ 1 ]),
		clone : f
	};
	window.$for = a;
	window.$foreach = g
})(JTopo);
(function(a) {
	function b(e) {
		var d = this;
		a.stage = d;
		this.initialize = function() {
			this.scenes = [];
			this.width = 0;
			this.height = 0;
			this.frames = 16;
			this.messageBus = new a.util.MessageBus();
			this.currentScene = null;
			this.canvas = e;
			this.width = e.width;
			this.height = e.height;
			this.graphics = e.getContext("2d");
			this.offsetX = e.offsetLeft;
			this.offsetY = e.offsetTop
		};
		this.initialize();
		function c(g) {
			var h = a.util.getXY(g);
			return {
				x : h.x - d.offsetX,
				y : h.y - d.offsetY,
				button : g.button,
				ctrlKey : g.ctrlkey,
				altKey : g.altkey,
				shiftKey : g.shiftKey,
				pageX : g.pageX,
				pageY : g.pageY,
				scene : d.currentScene
			}
		}
		var f = true;
		e.addEventListener("mouseout", function(g) {
			f = true;
			document.onselectstart = function() {
				return true
			}
		});
		e.addEventListener("mouseover", function(g) {
			f = false;
			document.onselectstart = function() {
				return false
			}
		});
		document.oncontextmenu = function(g) {
			return f
		};
		e.addEventListener("mousedown", function(h) {
			var g = c(h);
			d.dispatchEvent("mousedown", g);
			if (d.currentScene) {
				d.currentScene.mousedownHander(g)
			}
		});
		e.addEventListener("mouseup", function(h) {
			var g = c(h);
			d.dispatchEvent("mouseup", g);
			if (d.currentScene) {
				d.currentScene.mouseupHander(g)
			}
		});
		e.addEventListener("click", function(h) {
			var g = c(h);
			d.dispatchEvent("click", g);
			if (d.currentScene) {
				d.currentScene.clickHander(g)
			}
		});
		e.addEventListener("dblclick", function(h) {
			var g = c(h);
			d.dispatchEvent("dbclick", g);
			if (d.currentScene) {
				d.currentScene.dbclickHander(g)
			}
		});
		e.addEventListener("mousemove", function(h) {
			var g = c(h);
			d.dispatchEvent("mousemove", g);
			if (d.currentScene) {
				d.currentScene.mousemoveHander(g)
			}
		});
		window.addEventListener("keydown", function(g) {
			d.dispatchEvent("keydown", g);
			if (d.currentScene) {
				d.currentScene.keydownHander(g)
			}
		}, true);
		window.addEventListener("keyup", function(g) {
			d.dispatchEvent("keyup", g);
			if (d.currentScene) {
				d.currentScene.keyupHander(g)
			}
		}, true);
		this.play = function(g) {
			if (this.currentScene) {
				this.currentScene.hide()
			}
			this.currentScene = g;
			g.show();
			return this
		};
		this.remove = function(h) {
			for ( var g = 0; g < this.scenes.length; g++) {
				if (this.scenes[g] === h) {
					this.scenes = this.scenes.del(g);
					return this
				}
			}
		};
		this.addEventListener = function(g, h) {
			this.messageBus.subscribe(g, h);
			return this
		};
		this.dispatchEvent = function(g, h) {
			this.messageBus.publish(g, h);
			return this
		};
		this.saveImageInfo = function() {
			var h = this.canvas.toDataURL("image/png");
			var g = window.open("about:blank", "image from canvas");
			g.document.write("<img src='" + h + "' alt='from canvas'/>");
			return this
		};
		this.saveAsLocalImage = function() {
			var g = this.canvas.toDataURL("image/png").replace("image/png",
					"image/octet-stream");
			window.location.href = g;
			return this
		};
		this.repaint = function() {
			if (d.currentScene) {
				d.currentScene.repaint()
			}
			return this
		};
		(function() {
			d.repaint();
			setTimeout(arguments.callee, 1000 / d.frames)
		})()
	}
	a.Stage = b
})(JTopo);
(function(b) {
	function c(d) {
		this.initialize = function(f) {
			this.visible = false;
			this.rotate = 0;
			this.alpha = 1;
			this.eagleEye = {
				width : 180,
				height : 120,
				visible : false,
				translate : {
					x : 0,
					y : 0
				}
			};
			this.elements = [];
			this.elementMap = {};
			this.messageBus = new b.util.MessageBus();
			this.background = null;
			this.style = {
				fillStyle : "238,238,238"
			};
			this.shadow = true;
			this.operations = [];
			this.stage = f;
			this.stage.scenes.push(this);
			this.width = f.width;
			this.height = f.height;
			this.graphics = f.graphics
		};
		this.show = function() {
			this.visible = true;
			this.paint()
		};
		this.hide = function() {
			this.visible = false
		};
		this.clear = function() {
			this.elements = [];
			this.elementMap = [];
			this.operations = []
		};
		this.paintElements = function(m) {
			var l = this.graphics;
			for ( var h = 0; h < m.length; h++) {
				var f = m[h];
				l.save();
				if (f.translate) {
					var k = f.scalaX || 1;
					var j = f.scalaY || 1;
					l.translate(f.x + f.width * k / 2, f.y + f.height * j / 2);
					if (f.rotate) {
						l.rotate(f.rotate)
					}
					if (f.scalaX && f.scalaY) {
						l.scale(f.scalaX, f.scalaY)
					} else {
						if (f.scalaX) {
							l.scale(f.scalaX, 1)
						} else {
							if (f.scalaY) {
								l.scale(1, f.scalaY)
							}
						}
					}
				}
				f.paint(l);
				l.restore()
			}
		};
		this.paintOperations = function(f) {
			for ( var g = 0; g < f.length; g++) {
				f[g](this.graphics)
			}
		};
		this.addOperation = function(f) {
			this.operations.push(f);
			return this
		};
		this.clearOperations = function() {
			this.operations = [];
			return this
		};
		var e = {};
		this.setBackground = function(f) {
			if (typeof f == "string") {
				var g = e[f];
				if (g == null) {
					g = new Image();
					g.src = f;
					e[f] = g
				}
				this.background = g
			} else {
				this.background = f
			}
		};
		this.paintBackgroud = function(f) {
			this.graphics.save();
			if (this.background) {
				this.graphics.drawImage(f, 0 - this.eagleEye.translate.x,
						0 - this.eagleEye.translate.y, this.width, this.height)
			} else {
				this.graphics.fillStyle = "rgba(" + this.style.fillStyle + ","
						+ this.alpha + ")";
				this.graphics.fillRect(-this.eagleEye.translate.x,
						-this.eagleEye.translate.y, this.width, this.height)
			}
			this.graphics.restore()
		};
		this.paint = function() {
			if (!this.visible) {
				return
			}
			this.graphics.clearRect(0, 0, this.width, this.height);
			var f = this.graphics;
			f.save();
			if (this.shadow) {
				this.graphics.shadowBlur = 5;
				this.graphics.shadowColor = "rgba(0,0,0,0.5)";
				this.graphics.shadowOffsetX = 3;
				this.graphics.shadowOffsetY = 6
			}
			var h = null;
			if (this.eagleEye.visible && !b.util.isIE) {
				h = this.getEagleEyeImage(this.eagleEye.width,
						this.eagleEye.height);
				f.translate(this.eagleEye.translate.x,
						this.eagleEye.translate.y)
			}
			this.paintBackgroud(this.background);
			this.paintElements(this.elements);
			this.paintOperations(this.operations);
			if (this.eagleEye.visible && h != null && !b.util.isIE) {
				f.putImageData(h, this.width - this.eagleEye.width, this.height
						- this.eagleEye.height)
			}
			f.restore()
		};
		this.getEagleEyeImage = function(f, k) {
			var j = this.getBound();
			this.graphics.clearRect(0, 0, this.width, this.height);
			var m = f / j.width;
			var i = k / j.height;
			var l = this.graphics;
			l.save();
			if (m > 1) {
				m = 1
			}
			if (i > 1) {
				i = 1
			}
			if (m == 1 && i == 1) {
				return null
			}
			this.graphics.save();
			this.graphics.fillStyle = "rgba(0,255,0,0.3)";
			this.graphics.fillRect(0, 0, this.width, this.height);
			this.graphics.restore();
			l.translate(-j.x * m, -j.y * i);
			l.scale(m, i);
			this.paintElements(this.elements);
			this.paintOperations(this.operations);
			var n = l.getImageData(0, 0, f, k);
			l.restore();
			return n
		};
		this.getBound = function() {
			var l = {
				x : Number.MAX_VALUE,
				y : Number.MAX_VALUE,
				width : 0,
				height : 0
			};
			if (this.elements.length > 0) {
				var k = Number.MAX_VALUE;
				var g = Number.MIN_VALUE;
				var j = Number.MAX_VALUE;
				var f = Number.MIX_VALUE;
				var h = g - k;
				var o = f - j;
				for ( var n = 0; n < this.elements.length; n++) {
					var m = this.elements[n];
					if (m.x <= k) {
						k = m.x
					}
					if (m.x >= g) {
						g = m.x
					}
					if (m.y <= j) {
						j = m.y
					}
					if (m.y >= f) {
						f = m.y
					}
					h = g - k + (m.width || m.radius || 100);
					o = f - j + (m.height || m.radius || 100)
				}
				l.x = k - 10;
				l.y = j - 10;
				l.width = h;
				l.height = o
			}
			return l
		};
		this.repaint = function() {
			this.paint()
		};
		this.add = function(f) {
			if (!f.id) {
				f.id = "id_" + (new Date).getTime() + this.elements.length
			}
			if (!this.elementMap[f.id]) {
				this.elementMap[f.id] = f;
				this.elements.push(f)
			}
		};
		this.remove = function(f) {
			this.removeFromArray("elements", f)
		};
		this.removeFromArray = function(j, g) {
			var k = (typeof g) == "string" ? g : g.id;
			if (g.id == null) {
				return
			}
			if (this.elementMap[k]) {
				delete this.elementMap[k]
			}
			for ( var f = 0; f < this[j].length; f++) {
				var h = this[j][f];
				if (h.id === k) {
					this[j] = this[j].del(f);
					return h
				}
			}
			return null
		};
		this.getelementByXY = function(f, k) {
			var j = null;
			for ( var h = this.elements.length - 1; h >= 0; h--) {
				var g = this.elements[h];
				if (g.translate) {
					if (f > g.x && f < g.x + g.width * g.scalaX && k > g.y
							&& k < g.y + g.height * g.scalaY) {
						j = g;
						break
					}
				} else {
					if (f > g.x && f < g.x + g.width && k > g.y
							&& k < g.y + g.height) {
						j = g;
						break
					}
				}
			}
			return j
		};
		this.updateEyeView = function(f, h) {
			var g = this.getBound();
			this.eagleEye.translate.x = (this.eagleEye.width - (this.width - f))
					/ this.eagleEye.width;
			this.eagleEye.translate.y = (this.eagleEye.height - (this.height - h))
					/ this.eagleEye.height;
			this.eagleEye.translate.x *= -g.width;
			this.eagleEye.translate.y *= -g.height;
			this.eagleEye.translate.x += this.width / 2;
			this.eagleEye.translate.y += this.height / 2
		};
		this.toSceneEvent = function(f) {
			var g = b.util.clone(f);
			g.x = f.x - this.eagleEye.translate.x;
			g.y = f.y - this.eagleEye.translate.y;
			return g
		};
		this.mousedownHander = function(g) {
			this.isOnMouseDown = true;
			var f = g.x;
			var i = g.y;
			this.mouseDownX = f;
			this.mouseDownY = i;
			if (this.eagleEye.visible && f > this.width - this.eagleEye.width
					&& i > this.height - this.eagleEye.height) {
				this.updateEyeView(f, i)
			} else {
				var h = this.toSceneEvent(g);
				this.dispatchEvent("_mousedown", h)
			}
		};
		this.clickHander = function(f) {
			var g = this.toSceneEvent(f);
			this.dispatchEvent("_click", g)
		};
		this.dbclickHander = function(g) {
			this.isOnDbclick = true;
			var f = g.x;
			var i = g.y;
			this.dbclickX = f;
			this.dbclickY = i;
			var h = this.toSceneEvent(g);
			this.dispatchEvent("_dbclick", h)
		};
		this.mousemoveHander = function(i) {
			var f = i.x;
			var j = i.y;
			if (this.isOnMouseDown) {
				if (this.eagleEye.visible
						&& f > this.width - this.eagleEye.width
						&& j > this.height - this.eagleEye.height) {
					this.updateEyeView(f, j)
				} else {
					var h = (f - this.mouseDownX);
					var g = (j - this.mouseDownY);
					this.dispatchEvent("_mousedrag", {
						x : f - this.eagleEye.translate.x,
						y : j - this.eagleEye.translate.y,
						dx : h,
						dy : g,
						scene : this
					})
				}
			} else {
				this.dispatchEvent("_mousemove", {
					x : f - this.eagleEye.translate.x,
					y : j - this.eagleEye.translate.y,
					scene : this
				})
			}
		};
		this.mouseupHander = function(g) {
			var f = g.x;
			var i = g.y;
			this.isOnMouseDown = false;
			var h = this.toSceneEvent(g);
			this.dispatchEvent("_mouseup", h)
		};
		this.keydownHander = function(f) {
			this.dispatchEvent("_keydown", f)
		};
		this.keyupHander = function(f) {
			this.dispatchEvent("_keyup", f)
		};
		this.addEventListener = function(f, g) {
			this.messageBus.subscribe(f, g);
			return this
		};
		this.dispatchEvent = function(f, g) {
			this.messageBus.publish(f, g);
			return this
		}
	}
	b.AbstractScene = c;
	function a(d) {
		var f = this;
		this.initialize = function(g) {
			a.prototype.initialize.apply(this, arguments);
			this.nodes = [];
			this.links = [];
			this.containers = [];
			this.selectedElements = []
		};
		this.initialize(d);
		this.add = function(g) {
			a.prototype.add.call(this, g);
			if (g instanceof b.Node) {
				this.nodes.push(g)
			} else {
				if (g instanceof b.Link) {
					this.links.push(g)
				} else {
					if (g instanceof b.Container) {
						this.containers.push(g)
					} else {
					}
				}
			}
		};
		this.remove = function(g) {
			a.prototype.remove.call(this, g);
			this.removeFromArray("nodes", g);
			this.removeFromArray("links", g);
			this.removeFromArray("containers", g)
		};
		this.clear = function() {
			a.prototype.clear.call(this);
			this.nodes = [];
			this.links = [];
			this.container = []
		};
		var e = a.prototype.paintElements;
		this.paintElements = function() {
			e.call(this, this.containers);
			e.call(this, this.links);
			e.call(this, this.nodes)
		};
		this.pushSelected = function(g) {
			g.onSelected();
			this.selectedElements.push(g)
		};
		this.cancleAllSelected = function() {
			for ( var g = 0; g < this.selectedElements.length; g++) {
				this.selectedElements[g].cancleSelected()
			}
			this.selectedElements = []
		};
		this.notInSelectedNodes = function(h) {
			for ( var g = 0; g < this.selectedElements.length; g++) {
				if (h === this.selectedElements[g]) {
					return false
				}
			}
			return true
		};
		this.updateSelectedNodes = function() {
			for ( var g = 0; g < this.selectedElements.length; g++) {
				var h = this.selectedElements[g];
				h.onSelected()
			}
			return true
		};
		this.addEventListener("_mousedown", function(i) {
			var j = b.util.clone(i);
			j.scene = f;
			var g = i.x;
			var k = i.y;
			var h = f.getelementByXY(g, k);
			if (h) {
				h.onMousedown(j);
				j.target = h;
				f.dispatchEvent("mousedown", j);
				if (f.notInSelectedNodes(h)) {
					f.cancleAllSelected()
				} else {
					if (h != f.currentelement) {
						f.updateSelectedNodes(g, k)
					}
				}
				f.pushSelected(h)
			} else {
				f.cancleAllSelected();
				f.dispatchEvent("mousedown", j)
			}
			f.currentelement = h
		});
		this.addEventListener("_click", function(h) {
			var i = b.util.clone(h);
			var g = f.getelementByXY(h.x, h.y);
			if (g) {
				g.onClick(i)
			}
			f.dispatchEvent("click", i)
		});
		this.addEventListener("_dbclick", function(i) {
			var j = b.util.clone(i);
			j.scene = f;
			var g = i.x;
			var k = i.y;
			var h = f.getelementByXY(g, k);
			if (h) {
				h.onDbclick(j);
				j.target = h;
				f.dispatchEvent("dbclick", j)
			} else {
				f.cancleAllSelected();
				f.dispatchEvent("dbclick", j)
			}
			f.currentelement = h
		});
		this.addEventListener("_mousedrag", function(k) {
			var q = k.x;
			var p = k.y;
			var u = k.dx;
			var s = k.dy;
			if (f.currentelement && f.currentelement.dragable) {
				var m = b.util.clone(k);
				m.dx = u;
				m.dy = s;
				m.target = f.currentelement;
				f.currentelement.onMousedrag(m);
				f.dispatchEvent("mousedrag", m);
				for ( var n = 0; n < f.selectedElements.length; n++) {
					var o = f.selectedElements[n];
					if (o === f.currentelement) {
						continue
					}
					var h = o.selectedLocation.x + u;
					var t = o.selectedLocation.y + s;
					o.setLocation(h, t)
				}
			} else {
				var j = q >= f.mouseDownX ? f.mouseDownX : q;
				var g = p >= f.mouseDownY ? f.mouseDownY : p;
				var l = Math.abs(q - f.mouseDownX);
				var r = Math.abs(p - f.mouseDownY);
				f.clearOperations().addOperation(function(i) {
					i.beginPath();
					i.strokeStyle = "rgba(0,0,236,0.5)";
					i.fillStyle = "rgba(0,0,236,0.1)";
					i.rect(j, g, l, r);
					i.fill();
					i.stroke();
					i.closePath()
				});
				for ( var n = 0; n < f.elements.length; n++) {
					var o = f.elements[n];
					if (o.x > j && o.x + o.width < j + l) {
						if (o.y > g && o.y + o.height < g + r) {
							f.pushSelected(o)
						}
					} else {
						o.cancleSelected()
					}
				}
			}
		});
		this.addEventListener("_mousemove", function(i) {
			var h = i.x;
			var j = i.y;
			var g = f.getelementByXY(h, j);
			if (g) {
				if (f.mouseOverelement && f.mouseOverelement !== g) {
					f.mouseOverelement.onMouseout(i)
				}
				f.mouseOverelement = g;
				if (!g.isOnMousOver) {
					g.onMouseover(i);
					f.dispatchEvent("mouseover", {
						target : g,
						x : h,
						y : j,
						scene : f
					})
				}
			} else {
				if (f.mouseOverelement) {
					f.mouseOverelement.onMouseout(i);
					f.dispatchEvent("mouseout", {
						target : f.mouseOverelement,
						x : h,
						y : j,
						scene : f
					});
					f.mouseOverelement = null
				}
			}
		});
		this.addEventListener("_mouseup", function(i) {
			var g = i.x;
			var k = i.y;
			var h = f.currentelement;
			f.clearOperations();
			var j = b.util.clone(i);
			if (f.currentelement) {
				f.currentelement.onMouseup(j);
				j.target = f.currentelement;
				j.scene = f;
				f.dispatchEvent("mouseup", j)
			} else {
				f.dispatchEvent("mouseup", j)
			}
			if (h) {
				if (h.layout && h.layout.auto == true) {
					f.layoutNode(h)
				}
			}
		});
		this.isAllEndpoint = function(g) {
			for ( var h = 0; h < g.length; h++) {
				var j = this.getChilds(g[h]);
				if (j.length > 0) {
					return false
				}
			}
			return true
		};
		this.getChilds = function(j) {
			var g = [];
			for ( var h = 0; h < this.links.length; h++) {
				if (this.links[h].nodeA === j) {
					g.push(this.links[h].nodeZ)
				}
			}
			return g
		};
		this.layoutNode = function(h) {
			var j = this.getChilds(h);
			if (j.length == 0) {
				return null
			}
			b.Layout.adjustPosition(h, j);
			if (this.isAllEndpoint(j)) {
				return null
			}
			for ( var g = 0; g < j.length; g++) {
				this.layoutNode(j[g])
			}
			return null
		};
		return f
	}
	a.prototype = new b.AbstractScene();
	b.Scene = a
})(JTopo);
(function(c) {
	function a() {
		this.initialize = function() {
		};
		this.getLocation = function(f, g) {
			return {
				x : this.x,
				y : this.y
			}
		};
		this.setLocation = function(f, g) {
			this.x = f;
			this.y = g;
			return this
		};
		this.setCenterLocation = function(f, g) {
			this.x = f - this.width / 2;
			this.y = g - this.height / 2;
			return this
		};
		this.getCenterLocation = this.getCenterXY = function() {
			return {
				x : this.x + this.width / 2,
				y : this.y + this.height / 2
			}
		};
		this.getSize = function() {
			return {
				width : this.width,
				height : this.heith
			}
		};
		this.setSize = function(g, f) {
			this.width = g;
			this.height = f;
			return this
		};
		this.setBound = function(g, i, h, f) {
			this.setLocation(g, i);
			this.setSize(h, f);
			return this
		};
		this.getBound = function() {
			return {
				left : this.x,
				top : this.y,
				right : this.x + this.width,
				bottom : this.y + this.height
			}
		};
		this.onSelected = function() {
			this.selected = true;
			this.selectedLocation = {
				x : this.x,
				y : this.y
			}
		};
		this.cancleSelected = function() {
			this.selected = false;
			this.selectedLocation = null
		};
		this.onDbclick = function(f) {
			this.onDbclickX = f.x;
			this.onDbclickY = f.y;
			f.target = this;
			this.dispatchEvent("dbclick", f)
		};
		this.onClick = function(f) {
			this.clickX = f.x;
			this.clickY = f.y;
			this.onSelected();
			f.target = this;
			this.dispatchEvent("click", f)
		};
		this.onMousedown = function(f) {
			this.mousedownX = f.x;
			this.mousedownY = f.y;
			this.onSelected();
			f.target = this;
			this.dispatchEvent("mousedown", f)
		};
		this.onMouseup = function(f) {
			this.mouseupX = f.x;
			this.mouseupY = f.y;
			this.isOnMousedrag = false;
			f.target = this;
			this.dispatchEvent("mouseup", f)
		};
		this.onMouseover = function(f) {
			this.isOnMousOver = true;
			this.dispatchEvent("mouseover", f)
		};
		this.onMouseout = function(f) {
			this.isOnMousOver = false;
			f.target = this;
			this.dispatchEvent("mouseout", f)
		};
		this.onMousedrag = function(i) {
			this.isOnMousedrag = true;
			var g = i.dx;
			var f = i.dy;
			var j = this.selectedLocation.x + g;
			var h = this.selectedLocation.y + f;
			this.setLocation(j, h);
			i.target = this;
			this.dispatchEvent("mousedrag", i)
		};
		this.paint = function(f) {
			f.beginPath();
			f.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			f.rect(-this.width / 2, -this.height / 2, this.width, this.height);
			f.fill();
			f.closePath()
		};
		this.addEventListener = function(f, g) {
			if (!this.messageBus) {
				this.messageBus = new c.util.MessageBus()
			}
			this.messageBus.subscribe(f, g);
			return this
		};
		this.dispatchEvent = function(f, g) {
			if (!this.messageBus) {
				return null
			}
			this.messageBus.publish(f, g);
			return this
		}
	}
	function b() {
		this.initialize = function() {
			b.prototype.initialize.apply(this, arguments);
			this.x = 0;
			this.y = 0;
			this.width = 32;
			this.height = 32;
			this.visible = true;
			this.translate = true;
			this.alpha = 1;
			this.rotate = 0;
			this.scalaX = 1;
			this.scalaY = 1;
			this.style = {
				fillStyle : "22,119,238"
			}
		};
		this.initialize(arguments)
	}
	b.prototype = new a();
	function e(f, g) {
		this.initialize();
		var h = e.imageChace;
		if (h == null) {
			h = e.imageChace = {}
		}
		this.setImage = function(j, k) {
			var i = this;
			if (typeof j == "string") {
				var l = h[j];
				if (l == null) {
					l = new Image();
					l.src = j;
					if (k) {
						l.onload = function() {
							h[j] = l;
							i.setSize(l.width, l.height)
						}
					}
				} else {
					if (k) {
						this.setSize(l.width, l.height)
					}
				}
				this.image = l
			} else {
				this.image = j;
				if (k && j && j.width && j.height) {
					this.setSize(j.width, j.height)
				}
			}
		};
		if (f) {
			this.setImage(f, g)
		}
		this.paint = function(i) {
			if (!this.image) {
				return
			}
			i.save();
			i.beginPath();
			i.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			i.drawImage(this.image, -this.width / 2, -this.height / 2);
			i.fill();
			i.closePath();
			i.restore()
		}
	}
	e.prototype = new b();
	function d(f) {
		this.initialize();
		this.paint = f
	}
	d.prototype = new b();
	c.AbstractElement = a;
	c.Element = b;
	c.ImageElement = e;
	c.CustomElement = d
})(JTopo);
(function(j) {
	function h(k) {
		this.initialize = function(l) {
			h.prototype.initialize.apply(this, arguments);
			this.style.fontColor = "255,255,255";
			this.style.fontSize = "10pt";
			this.style.font = "Consolas";
			this.name = l;
			this.dragable = true;
			this.selectable = true;
			this.selected = false;
			this.label = {
				position : "Bottom_Center"
			}
		};
		this.initialize(k);
		this.paint = function(l) {
			if (this.selected || this.isOnMousOver) {
				this.drawSelectedRect(l)
			}
			if (this.image) {
				h.prototype.paint.call(this, l)
			} else {
				l.beginPath();
				l.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
						+ ")";
				l.rect(-this.width / 2, -this.height / 2, this.width,
						this.height);
				l.fill();
				l.closePath()
			}
			this.drawText(l)
		};
		this.drawSelectedRect = function(m) {
			if (!this.selectable) {
				return
			}
			var p = this.name;
			var o = p ? m.measureText(p).width : 0;
			var n = p ? 16 : 6;
			var l = Math.max(this.width, o);
			m.save();
			m.beginPath();
			m.strokeStyle = "rgba(168,202,255, 0.9)";
			m.fillStyle = "rgba(168,202,236,0.7)";
			m.rect(-l / 2 - 3, -this.height / 2 - 3, l + 6, this.height + n);
			m.fill();
			m.stroke();
			m.closePath();
			m.restore()
		};
		this.drawText = function(l) {
			var m = this.name;
			if (!m || m == "") {
				return
			}
			var o = l.measureText(m).width;
			l.beginPath();
			l.font = this.style.fontSize + " " + this.style.font;
			l.strokeStyle = "rgba(" + this.style.fontColor + ", " + this.alpha
					+ ")";
			var n = this.getTextPostion(this.label.position, o);
			l.strokeText(m, n.x, n.y);
			l.closePath()
		};
		this.getTextPostion = function(o, q) {
			var n = {
				Top_Center : function() {
					return {
						x : -this.width / 2 + (this.width - q) / 2,
						y : -this.height / 2
					}
				},
				Top_Right : function() {
					return {
						x : this.width / 2,
						y : -this.height / 2
					}
				},
				Top_Left : function() {
					return {
						x : -this.width / 2 - q,
						y : -this.height / 2
					}
				},
				Bottom_Center : function() {
					return {
						x : -this.width / 2 + (this.width - q) / 2,
						y : this.height / 2 + 12
					}
				},
				Bottom_Right : function() {
					return {
						x : this.width / 2,
						y : this.height / 2 + 12
					}
				},
				Bottom_Left : function() {
					return {
						x : -this.width / 2 - q,
						y : this.height / 2 + 12
					}
				},
				Middle_Center : function() {
					return {
						x : -this.width / 2 + (this.width - q) / 2,
						y : 0
					}
				},
				Middle_Right : function() {
					return {
						x : this.width / 2,
						y : 0
					}
				},
				Middle_Left : function() {
					return {
						x : -this.width / 2 - q,
						y : 0
					}
				}
			};
			var m = n[o];
			if (m == null) {
				m = n.Bottom_Center
			}
			var l = m.call(this);
			if (this.label.offsetX && (typeof this.label.offsetX) === "number") {
				l.x += this.label.offsetX
			}
			if (this.label.offsetY && (typeof this.label.offsetY) === "number") {
				l.y += this.label.offsetY
			}
			return l
		}
	}
	h.prototype = new j.ImageElement();
	function a(k) {
		this.initialize();
		this.height = 14;
		this.name = k;
		this.paint = function(l) {
			var m = l.measureText(this.name).width;
			this.width = m;
			l.beginPath();
			l.font = this.style.fontSize + " " + this.style.font;
			l.strokeStyle = "rgba(" + this.style.fontColor + ", " + this.alpha
					+ ")";
			l.strokeText(this.name, -this.width / 2, -this.height / 2 + 12);
			l.closePath()
		}
	}
	a.prototype = new h();
	function i(k) {
		this.initialize();
		this.setSize(100, 100);
		this.name = k;
		this.translate = false;
		this.paint = function(m) {
			if (!this.visible) {
				return
			}
			var l = this.x;
			var n = this.y;
			m.beginPath();
			m.strokeStyle = "rgba(230, 230, 230, 0.8)";
			m.moveTo(l + 50, n);
			m.quadraticCurveTo(l, n, l, n + 37.5);
			m.quadraticCurveTo(l, n + 75, l + 25, n + 75);
			m.quadraticCurveTo(l + 25, n + 95, l + 5, n + 100);
			m.quadraticCurveTo(l + 35, n + 95, l + 45, n + 75);
			m.quadraticCurveTo(l + 100, n + 75, l + 100, n + 37.5);
			m.quadraticCurveTo(l + 100, n, l + 50, n);
			m.strokeText(this.name, this.x + 20, this.y + 20);
			m.stroke();
			m.closePath()
		}
	}
	i.prototype = new h();
	function d() {
		this.initialize();
		this.setSize(120, 120);
		this.translate = false;
		this.paint = function(k) {
			if (!this.visible) {
				return
			}
			k.save();
			k.beginPath();
			k.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			k.moveTo(this.x + 75, this.y + 40);
			k.bezierCurveTo(this.x + 75, this.y + 37, this.x + 70, this.y + 25,
					this.x + 50, this.y + 25);
			k.bezierCurveTo(this.x + 20, this.y + 25, this.x + 20,
					this.y + 62.5, this.x + 20, this.y + 62.5);
			k.bezierCurveTo(this.x + 20, this.y + 80, this.x + 40,
					this.y + 102, this.x + 75, this.y + 120);
			k.bezierCurveTo(this.x + 110, this.y + 102, this.x + 130,
					this.y + 80, this.x + 130, this.y + 62.5);
			k.bezierCurveTo(this.x + 130, this.y + 62.5, this.x + 130,
					this.y + 25, this.x + 100, this.y + 25);
			k.bezierCurveTo(this.x + 85, this.y + 25, this.x + 75, this.y + 37,
					this.x + 75, this.y + 40);
			k.fill();
			k.closePath();
			k.restore()
		}
	}
	d.prototype = new h();
	function f(k) {
		this.initialize();
		this.style.fillStyle = "71, 167, 184";
		this.className = k;
		this.rowHeight = 18;
		this.width = 268;
		this.classObj = null;
		this.translate = false;
		this.operations = null;
		this.attributes = null;
		this.maxItem = 10;
		this.paint = function(q) {
			if (!this.visible) {
				return
			}
			if (this.classObj != null) {
				this.operations = [];
				this.attributes = [];
				for ( var n in this.classObj) {
					if (p > this.maxItem) {
						break
					}
					var t = this.classObj[n];
					if (typeof t == "function") {
						var s = "(";
						for ( var p = 0; p < t.length; p++) {
							s += "arg" + p;
							if (p + 1 < t.length) {
								s += ", "
							}
						}
						s += ")";
						if (n.length + s.length > 35) {
							this.operations.push("+ " + n
									+ s.substring(0, 35 - n.length));
							this.operations.push("  "
									+ s.substring(35 - n.length))
						} else {
							this.operations.push("+ " + n + s)
						}
					} else {
						this.attributes.push("- " + n + ": " + (typeof t))
					}
				}
			}
			if (this.operations == null || this.operations.length == 0) {
				this.operations = [ " " ]
			}
			if (this.attributes == null || this.attributes.length == 0) {
				this.attributes = [ " " ]
			}
			if (this.operations.length > this.maxItem) {
				this.operations = this.operations.splice(0, this.maxItem);
				this.operations.push("  ...")
			}
			if (this.attributes.length > this.maxItem) {
				this.attributes = this.attributes.splice(0, this.maxItem);
				this.attributes.push("  ...")
			}
			this.height = (this.operations.length + this.attributes.length + 1)
					* this.rowHeight + 3;
			q.save();
			q.beginPath();
			q.fillStyle = "rgba(239,247,149," + this.alpha + ")";
			q.rect(this.x, this.y, this.width, this.height);
			q.shadowBlur = 0;
			q.shadowOffsetX = 0;
			q.shadowOffsetY = 0;
			q.fill();
			q.font = this.style.fontSize + " " + this.style.font;
			q.moveTo(this.x, this.y + this.rowHeight + 3);
			q.lineTo(this.x + this.width, this.y + this.rowHeight + 3);
			var r = q.measureText(this.className).width;
			q.strokeText(this.className, this.x + (this.width - r) / 2, this.y
					+ this.rowHeight);
			for ( var p = 0; p < this.operations.length; p++) {
				var o = this.operations[p];
				q.strokeText(o, this.x + 5, this.y + this.rowHeight
						+ this.rowHeight * (p + 1))
			}
			q.moveTo(this.x, this.y + this.rowHeight
					* (this.operations.length + 1) + 3);
			q.lineTo(this.x + this.width, this.y + this.rowHeight
					* (this.operations.length + 1) + 3);
			var m = this.y + this.rowHeight * (this.operations.length + 1);
			for ( var p = 0; p < this.attributes.length; p++) {
				var l = this.attributes[p];
				q.strokeText(l, this.x + 5, m + this.rowHeight * (p + 1))
			}
			q.stroke();
			q.closePath();
			q.restore()
		}
	}
	f.prototype = new h();
	function c(k) {
		this.initialize();
		this.radius = 30;
		this.beginDegree = 0;
		this.endDegree = 2 * Math.PI;
		this.name = k;
		this.paint = function(m) {
			if (this.selected || this.isOnMousOver) {
				this.drawSelectedRect(m)
			}
			if (this.visible == false) {
				return
			}
			var l = this.radius * 2;
			var n = this.radius * 2;
			this.width = l;
			this.height = n;
			m.save();
			m.beginPath();
			m.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			m.arc(0, 0, this.radius, this.beginDegree, this.endDegree, true);
			m.fill();
			m.closePath();
			m.restore();
			this.drawText(m)
		}
	}
	c.prototype = new h();
	function e(k, o, m) {
		this.initialize();
		this.frameImages = k || [];
		this.frameIndex = 0;
		this.isStop = true;
		var n = o || 1000;
		this.repeatPlay = false;
		var l = this;
		this.nextFrame = function() {
			if (this.isStop) {
				return
			}
			if (this.frameImages.length == null) {
				return
			}
			this.frameIndex++;
			if (this.frameIndex >= this.frameImages.length) {
				if (this.repeatPlay) {
					this.frameIndex = 0
				} else {
					return
				}
			}
			this.setImage(this.frameImages[this.frameIndex], m);
			setTimeout(function() {
				l.nextFrame()
			}, n / k.length)
		}
	}
	e.prototype = new h();
	function g(q, n, p, o, m) {
		this.initialize();
		var k = this;
		this.setImage(q);
		this.frameIndex = 0;
		this.isPause = true;
		this.repeatPlay = false;
		var l = o || 1000;
		m = m || 0;
		this.paint = function(u) {
			if (!this.image) {
				return
			}
			var r = this.width;
			var t = this.height;
			u.save();
			u.beginPath();
			u.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			var v = (Math.floor(this.frameIndex / p) + m) * t;
			var s = Math.floor(this.frameIndex % p) * r;
			u.drawImage(this.image, s, v, r, t, -r / 2, -t / 2, r, t);
			u.fill();
			u.closePath();
			u.restore()
		};
		this.nextFrame = function() {
			if (this.isStop) {
				return
			}
			this.frameIndex++;
			if (this.frameIndex >= n * p) {
				if (this.repeatPlay) {
					this.frameIndex = 0
				} else {
					return
				}
			}
			setTimeout(function() {
				if (k.isStop) {
					return
				}
				k.nextFrame()
			}, l / (n * p))
		}
	}
	g.prototype = new h();
	function b() {
		var k = null;
		if (arguments.length <= 3) {
			k = new e(arguments[0], arguments[1], arguments[2])
		} else {
			k = new g(arguments[0], arguments[1], arguments[2], arguments[3],
					arguments[4], arguments[5])
		}
		k.stop = function() {
			k.isStop = true
		};
		k.play = function() {
			k.isStop = false;
			k.frameIndex = 0;
			k.nextFrame()
		};
		return k
	}
	b.prototype = new h();
	j.Node = h;
	j.TextNode = a;
	j.UMLClassNode = f;
	j.TipNode = i;
	j.HeartNode = d;
	j.CircleNode = c;
	j.AnimateNode = b
})(JTopo);
(function(e) {
	function d(j, i, h) {
		this.initialize = function(m, l, k) {
			if (arguments.length == 0) {
				return
			}
			this.name = k;
			this.nodeA = m;
			this.nodeZ = l;
			this.alpha = 1;
			this.style = {
				strokeStyle : "116, 166, 250",
				lineWidth : 2,
				fontSize : "12pt",
				fontColor : "255,255,0",
				lineJoin : "miter"
			}
		};
		this.initialize(j, i, h);
		this.paint = function(k) {
			if (!this.nodeA || !this.nodeZ) {
				return
			}
			k.beginPath();
			k.strokeStyle = "rgba(" + this.style.strokeStyle + "," + this.alpha
					+ ")";
			k.lineWidth = this.style.lineWidth;
			if (j === i) {
				k.arc(this.nodeA.x, this.nodeA.y, j.width / 2, 0, 2 * Math.PI)
			} else {
				k.moveTo(this.nodeA.x + this.nodeA.width / 2, this.nodeA.y
						+ this.nodeA.height / 2);
				k.lineTo(this.nodeZ.x + this.nodeZ.width / 2, this.nodeZ.y
						+ this.nodeZ.height / 2)
			}
			k.stroke();
			k.closePath();
			this.paintText(k)
		};
		this.paintText = function(l) {
			if (this.name) {
				var k = this.name;
				if (!k || k == "") {
					return
				}
				var m = l.measureText(k).width;
				l.beginPath();
				l.lineWidth = 1;
				l.font = this.style.fontSize + " " + this.style.font;
				l.strokeStyle = "rgba(" + this.style.fontColor + ", "
						+ this.alpha + ")";
				l.strokeText(k, this.nodeA.x + (this.nodeZ.x - this.nodeA.x)
						/ 2, this.nodeA.y + (this.nodeZ.y - this.nodeA.y) / 2
						+ 12);
				l.stroke();
				l.closePath()
			}
		}
	}
	d.prototype = new e.AbstractElement();
	function f(k, j, i, h) {
		this.initialize = function() {
			f.prototype.initialize.apply(this, arguments);
			this.fold = h || "x"
		};
		this.initialize(k, j, i, h);
		this.paint = function(l) {
			if (!this.nodeA || !this.nodeZ) {
				return
			}
			var n = this.nodeA.getCenterXY();
			var m = this.nodeZ.getCenterXY();
			l.save();
			l.beginPath();
			l.lineJoin = this.style.lineJoin;
			l.strokeStyle = "rgba(" + this.style.strokeStyle + "," + this.alpha
					+ ")";
			l.lineWidth = this.style.lineWidth;
			l.moveTo(n.x, n.y);
			if (this.fold == "y") {
				l.lineTo(n.x, m.y)
			} else {
				l.lineTo(m.x, n.y)
			}
			l.lineTo(m.x, m.y);
			l.stroke();
			l.closePath();
			l.restore()
		}
	}
	f.prototype = new d();
	function g(j, i, h) {
		this.initialize = function() {
			g.prototype.initialize.apply(this, arguments);
			this.offset = 20
		};
		this.initialize(j, i, h);
		this.paint = function(l) {
			if (!this.nodeA || !this.nodeZ) {
				return
			}
			l.beginPath();
			l.strokeStyle = "rgba(" + this.style.strokeStyle + "," + this.alpha
					+ ")";
			l.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			l.lineWidth = this.style.lineWidth;
			l.lineJoin = this.style.lineJoin;
			var m = {
				x : this.nodeA.x + this.nodeA.width / 2,
				y : this.nodeA.y + this.nodeA.height / 2
			};
			var o = {
				x : this.nodeZ.x + this.nodeZ.width / 2,
				y : this.nodeZ.y + this.nodeZ.height / 2
			};
			var p = Math.atan2(m.y - o.y, m.x - o.x);
			o.x = o.x + Math.cos(p) * this.nodeZ.width / 2;
			o.y = o.y + Math.sin(p) * this.nodeZ.height / 2;
			var n = 0.4;
			var k = {
				x : o.x + Math.cos(p - n) * this.offset,
				y : o.y + Math.sin(p - n) * this.offset
			};
			var q = {
				x : o.x + Math.cos(p + n) * this.offset,
				y : o.y + Math.sin(p + n) * this.offset
			};
			l.moveTo(this.nodeA.x + this.nodeA.width / 2, this.nodeA.y
					+ this.nodeA.height / 2);
			l.lineTo(k.x + (q.x - k.x) / 2, k.y + (q.y - k.y) / 2);
			l.moveTo(k.x, k.y);
			l.lineTo(o.x, o.y);
			l.lineTo(q.x, q.y);
			l.lineTo(k.x, k.y);
			if (this.style.fillStyle != null) {
				l.fill()
			}
			l.stroke();
			l.closePath()
		}
	}
	g.prototype = new d();
	function c(k, j, i, h) {
		this.initialize = function() {
			c.prototype.initialize.apply(this, arguments);
			this.offset = 20;
			this.fold = h || "x";
			this.offset = 20
		};
		this.initialize(k, j, i, h);
		this.paint = function(w) {
			if (!this.nodeA || !this.nodeZ) {
				return
			}
			var n = this.nodeA.x;
			var r = this.nodeA.y;
			var m = this.nodeZ.x;
			var q = this.nodeZ.y;
			var u = n;
			var s = r;
			if (n == m || r == q) {
				w.save();
				w.beginPath();
				w.strokeStyle = "rgba(" + this.style.strokeStyle + ","
						+ this.alpha + ")";
				w.lineWidth = this.style.lineWidth;
				w.lineJoin = this.style.lineJoin;
				var p = {
					x : this.nodeA.x + this.nodeA.width / 2,
					y : this.nodeA.y + this.nodeA.height / 2
				};
				var v = {
					x : this.nodeZ.x + this.nodeZ.width / 2,
					y : this.nodeZ.y + this.nodeZ.height / 2
				};
				var o = Math.atan2(p.y - v.y, p.x - v.x);
				v.x = v.x + Math.cos(o) * this.nodeZ.width / 2;
				v.y = v.y + Math.sin(o) * this.nodeZ.height / 2;
				var y = 0.4;
				var l = {
					x : v.x + Math.cos(o - y) * this.offset,
					y : v.y + Math.sin(o - y) * this.offset
				};
				var x = {
					x : v.x + Math.cos(o + y) * this.offset,
					y : v.y + Math.sin(o + y) * this.offset
				};
				w.lineTo(l.x + (x.x - l.x) / 2, l.y + (x.y - l.y) / 2);
				w.moveTo(l.x, l.y);
				w.lineTo(v.x, v.y);
				w.lineTo(x.x, x.y);
				w.lineTo(l.x, l.y);
				if (this.style.fillStyle != null) {
					w.fill()
				}
				w.closePath();
				w.stroke();
				w.restore()
			} else {
				if (this.fold == "x") {
					u = n + (m - n)
				} else {
					s = r + (q - r)
				}
				w.save();
				w.beginPath();
				w.strokeStyle = "rgba(" + this.style.strokeStyle + ","
						+ this.alpha + ")";
				w.lineWidth = this.style.lineWidth;
				w.lineJoin = this.style.lineJoin;
				w.moveTo(n + this.nodeA.width / 2, r + this.nodeA.height / 2);
				w.lineTo(u + this.nodeA.width / 2, s + this.nodeA.height / 2);
				var p = {
					x : u + this.nodeA.width / 2,
					y : s + this.nodeA.height / 2
				};
				var v = {
					x : this.nodeZ.x + this.nodeZ.width / 2,
					y : this.nodeZ.y + this.nodeZ.height / 2
				};
				var o = Math.atan2(p.y - v.y, p.x - v.x);
				v.x = v.x + Math.cos(o) * this.nodeZ.width / 2;
				v.y = v.y + Math.sin(o) * this.nodeZ.height / 2;
				var y = 0.4;
				var l = {
					x : v.x + Math.cos(o - y) * this.offset,
					y : v.y + Math.sin(o - y) * this.offset
				};
				var x = {
					x : v.x + Math.cos(o + y) * this.offset,
					y : v.y + Math.sin(o + y) * this.offset
				};
				w.lineTo(l.x + (x.x - l.x) / 2, l.y + (x.y - l.y) / 2);
				w.moveTo(l.x, l.y);
				w.lineTo(v.x, v.y);
				w.lineTo(x.x, x.y);
				w.lineTo(l.x, l.y);
				if (this.style.fillStyle != null) {
					w.fill()
				}
				w.stroke();
				w.closePath();
				w.restore()
			}
		}
	}
	c.prototype = new d();
	function b(k, j, h) {
		this.initialize = function() {
			c.prototype.initialize.apply(this, arguments);
			this.flexional = {
				direction : "vertical",
				extend : function() {
					return 20
				}
			}
		};
		this.initialize(k, j, h);
		var i = this.paintText;
		this.paint = function(m) {
			if (!this.nodeA || !this.nodeZ) {
				return
			}
			var p = this.nodeA.x;
			var r = this.nodeA.y;
			var o = this.nodeZ.x;
			var q = this.nodeZ.y;
			m.beginPath();
			m.lineJoin = this.style.lineJoin;
			m.strokeStyle = "rgba(" + this.style.strokeStyle + "," + this.alpha
					+ ")";
			m.lineWidth = this.style.lineWidth;
			if (p == o || r == q) {
				m.moveTo(this.nodeA.x + this.nodeA.width / 2, this.nodeA.y
						+ this.nodeA.height / 2);
				m.lineTo(this.nodeZ.x + this.nodeZ.width / 2, this.nodeZ.y
						+ this.nodeZ.height / 2)
			} else {
				var n = (this.flexional.direction == "horizontal" ? this.flexional
						.extend()
						: 0);
				var l = (this.flexional.direction == "vertical" ? this.flexional
						.extend()
						: 0);
				n *= (o - p) > 0 ? 1 : -1;
				l *= (q - r) > 0 ? 1 : -1;
				m.moveTo(p + this.nodeA.width / 2, r + this.nodeA.height / 2);
				m.lineTo(p + this.nodeA.width / 2 + n, r + this.nodeA.height
						/ 2 + l);
				m.lineTo(o + this.nodeA.width / 2 - n, q + this.nodeA.height
						/ 2 - l);
				m.lineTo(o + this.nodeA.width / 2, q + this.nodeA.height / 2)
			}
			m.stroke();
			m.closePath();
			i.call(this, m)
		}
	}
	b.prototype = new d();
	function a(j, i, h) {
		this.initialize = function() {
			c.prototype.initialize.apply(this, arguments)
		};
		this.initialize(j, i, h);
		this.flexional.extend = function() {
			if (this.flexional.direction == "horizontal") {
				return Math.abs(i.x - j.x) / 2
			} else {
				return Math.abs(i.y - j.y) / 2
			}
		}
	}
	a.prototype = new b();
	e.Link = d;
	e.FoldLink = f;
	e.ArrowsLink = g;
	e.ArrowsFoldLink = c;
	e.FlexionalLink = b;
	e.OrthogonalLink = a
})(JTopo);
(function(c) {
	function b(e) {
		this.initialize = function(f) {
			b.prototype.initialize.apply(this, null);
			this.name = f;
			this.x = 0;
			this.y = 0;
			this.width = 100;
			this.height = 100;
			this.items = [];
			this.style = {
				fillStyle : "255, 255, 255"
			};
			this.alpha = 0.6;
			this.dragable = true;
			this.childDragble = null;
			this.visible = true
		};
		this.initialize(e);
		this.add = function(f) {
			this.items.push(f);
			f.parentContainer = this;
			this.updateBound();
			if (this.childDragble) {
				f.dragable = this.childDragble
			}
		};
		this.remove = function(g) {
			for ( var f = 0; f < this.items.length; f++) {
				if (this.items[f] === g) {
					g.parentContainer = null;
					this.items = this.items.del(f);
					g.lastParentContainer = this;
					break
				}
			}
		};
		this.clear = this.removeAll = function() {
			for ( var f = 0; f < this.items.length; f++) {
				this.remove(this.items[f])
			}
		};
		this.setLocation = function(f, l) {
			var h = f - this.x;
			var g = l - this.y;
			this.x = f;
			this.y = l;
			for ( var j = 0; j < this.items.length; j++) {
				var k = this.items[j];
				k.setLocation(k.x + h, k.y + g)
			}
		};
		this.updateBound = function() {
			for ( var f = 0; f < this.items.length; f++) {
				var g = this.items[f];
				if (g.x < this.x) {
					g.x = this.x
				}
				if (g.y < this.y) {
					g.y = this.y
				}
				if (g.x + g.width > this.x + this.width) {
					g.x = this.x + this.width - g.width
				}
				if (g.y + g.height > this.y + this.height) {
					g.y = this.y + this.height - g.height
				}
			}
		};
		this.paint = function(f) {
			if (this.layout) {
				c.Layout.adjustPosition(this, this.items)
			}
			this.updateBound();
			if (!this.visible) {
				return
			}
			f.beginPath();
			f.shadowBlur = 9;
			f.shadowColor = "rgba(0,0,0,0.5)";
			f.shadowOffsetX = 3;
			f.shadowOffsetY = 3;
			f.fillStyle = "rgba(" + this.style.fillStyle + "," + this.alpha
					+ ")";
			f.fillRect(this.x, this.y, this.width, this.height);
			f.closePath()
		}
	}
	b.prototype = new c.AbstractElement();
	function d() {
		this.initialize(arguments);
		this.updateBound = function() {
			var k = {
				x : 10000000,
				y : 1000000,
				width : 0,
				height : 0
			};
			if (this.items.length > 0) {
				var j = 10000000;
				var f = -10000000;
				var h = 10000000;
				var e = -10000000;
				var g = f - j;
				var m = e - h;
				for ( var l = 0; l < this.items.length; l++) {
					var n = this.items[l];
					if (n.x <= j) {
						j = n.x
					}
					if (n.x >= f) {
						f = n.x
					}
					if (n.y <= h) {
						h = n.y
					}
					if (n.y >= e) {
						e = n.y
					}
					g = f - j + n.width;
					m = e - h + n.height
				}
				this.x = j;
				this.y = h;
				this.width = g;
				this.height = m
			}
		}
	}
	d.prototype = new b();
	function a() {
		this.initialize(arguments);
		this.paint = function(f) {
			if (this.items.length < 2) {
				return
			}
			var j = [];
			for ( var e = 0; e < this.items.length; e++) {
				var h = this.items[e].getCenterXY();
				j.push(h)
			}
			for ( var e = 0; e < j.length - 2; e += 3) {
				f.beginPath();
				f.moveTo(j[e].x, j[e].y);
				this.items[e + 1].style.fillStyle = "0,255,0";
				f.quadraticCurveTo(j[e + 1].x, j[e + 1].y, j[e + 2].x,
						j[e + 2].y);
				f.stroke();
				f.closePath();
				f.save();
				f.beginPath();
				f.lineWidth = 1;
				f.strokeStyle = "rgba(0,255,0,0.3)";
				f.moveTo(j[e].x, j[e].y);
				f.lineTo(j[e + 1].x, j[e + 1].y);
				f.stroke();
				f.closePath();
				f.restore()
			}
		}
	}
	a.prototype = new b();
	c.Container = b;
	c.AutoSizeContainer = d;
	c.EditContainer = a
})(JTopo);
(function(b) {
	function a(r, q, l, m, n, o) {
		var g = n ? n : 0;
		var j = o ? o : 2 * Math.PI;
		var p = j - g;
		var h = p / l;
		var u = [];
		g += h / 2;
		for ( var k = g; k <= j; k += h) {
			var t = r + Math.cos(k) * m;
			var s = q + Math.sin(k) * m;
			u.push({
				x : t,
				y : s
			})
		}
		return u
	}
	function c(p, n, m, g, k, j) {
		var o = j || "bottom";
		var q = [];
		if (o == "bottom") {
			var h = p - (m / 2) * g + g / 2;
			for ( var l = 0; l <= m; l++) {
				q.push({
					x : h + l * g,
					y : n + k
				})
			}
		} else {
			if (o == "top") {
				var h = p - (m / 2) * g + g / 2;
				for ( var l = 0; l <= m; l++) {
					q.push({
						x : h + l * g,
						y : n - k
					})
				}
			} else {
				if (o == "right") {
					var h = n - (m / 2) * g + g / 2;
					for ( var l = 0; l <= m; l++) {
						q.push({
							x : p + k,
							y : h + l * g
						})
					}
				} else {
					if (o == "left") {
						var h = n - (m / 2) * g + g / 2;
						for ( var l = 0; l <= m; l++) {
							q.push({
								x : p - k,
								y : h + l * g
							})
						}
					}
				}
			}
		}
		return q
	}
	function f(p, n, m, g, k, j) {
		var o = j || "horizontal";
		var s = [];
		var q = Math.round(m / 2);
		var h = p + g;
		if (o == "horizontal") {
			for ( var l = 0; l < q; l++) {
				s.push({
					x : h + l * g,
					y : n - k
				})
			}
			for ( var l = q; l <= m; l++) {
				s.push({
					x : h + l * g,
					y : n + k
				})
			}
		} else {
			if (o == "vertical") {
			}
		}
		return s
	}
	function e(o, m, p, n, g, h) {
		var q = [];
		for ( var l = 0; l < p; l++) {
			for ( var k = 0; k < n; k++) {
				q.push({
					x : o + k * g,
					y : m + l * h
				})
			}
		}
		return q
	}
	function d(l, m) {
		if (!l.layout) {
			return
		}
		var k = l.layout;
		var j = k.type;
		var h = null;
		var n = l.getCenterXY();
		if (j == "star") {
			h = a(n.x, n.y, m.length, l.layout.radius, l.layout.beginDegree,
					l.layout.endDegree)
		} else {
			if (j == "tree") {
				h = c(n.x, n.y, m.length, k.width, k.height, k.direction)
			} else {
				if (j == "grid") {
					h = e(n.x, n.y, k.rows, k.cols, k.horizontal || 0,
							k.vertical || 0)
				} else {
					return
				}
			}
		}
		for ( var g = 0; g < m.length; g++) {
			m[g].setCenterLocation(h[g].x, h[g].y)
		}
	}
	b.Layout = {
		adjustPosition : d
	}
})(JTopo);
(function(a) {
	function b() {
		var c = new a.CircleNode();
		c.radius = 150;
		c.colors = [ "#3666B0", "#2CA8E0", "#77D1F6" ];
		c.datas = [ 0.3, 0.3, 0.4 ];
		c.translate = false;
		c.paint = function(e) {
			var d = c.radius * 2;
			var g = c.radius * 2;
			c.width = d;
			c.height = d;
			var j = 0;
			for ( var f = 0; f < this.datas.length; f++) {
				var k = this.datas[f] * Math.PI * 2;
				e.beginPath();
				e.fillStyle = c.colors[f];
				e.moveTo(this.x + d / 2, this.y + g / 2);
				e.arc(this.x + d / 2, this.y + g / 2, this.radius / 2, j,
						j + k, false);
				e.fill();
				e.closePath();
				j += k
			}
		};
		return c
	}
	a.PieChartNode = b
})(JTopo);
(function(c) {
	c.Animate = {};
	c.Effect = {};
	function a(h, g) {
		var f = null;
		var i;
		return {
			stop : function() {
				if (!i) {
					return this
				}
				window.clearInterval(i);
				if (f) {
					f.publish("stop")
				}
				return this
			},
			start : function() {
				var j = this;
				i = setInterval(function() {
					h.call(j)
				}, g);
				return this
			},
			onStop : function(j) {
				if (f == null) {
					f = new c.util.MessageBus()
				}
				f.subscribe("stop", j);
				return this
			}
		}
	}
	function e(k, l) {
		l = l || {};
		var m = l.gravity || 0.1;
		var i = l.dx || 0;
		var f = l.dy || 5;
		var j = l.stop;
		var h = l.interval || 30;
		var g = new a(function() {
			if (j && j()) {
				f = 0.5;
				this.stop()
			} else {
				f += m;
				k.setLocation(k.x + i, k.y + f)
			}
		}, h);
		return g
	}
	function b(n, o, f, p, q) {
		var h = 50;
		var i = {};
		for ( var j in o) {
			var m = o[j];
			var l = m - n[j];
			i[j] = {
				oldValue : n[j],
				targetValue : m,
				step : l / f * h,
				isDone : function(s) {
					var r = (this.step > 0 && n[s] >= this.targetValue)
							|| (this.step < 0 && n[s] <= this.targetValue);
					return r
				}
			}
		}
		var g = new a(function() {
			var t = true;
			for ( var s in o) {
				if (i[s].isDone(s)) {
				} else {
					n[s] += i[s].step;
					t = false
				}
			}
			if (t) {
				if (p) {
					for ( var s in o) {
						if (q) {
							var r = i[s].targetValue;
							i[s].targetValue = i[s].oldValue;
							i[s].oldValue = r;
							i[s].step = -i[s].step
						} else {
							n[s] = i[s].oldValue
						}
					}
				} else {
					return this.stop()
				}
			}
		}, h);
		return g
	}
	function d(g, i) {
		var f = g.style;
		var h = i.angle;
		function l(o, u, s, t, p) {
			var q = new c.Node();
			q.setImage(g.image);
			q.setSize(g.width, g.height);
			q.style = f;
			q.setLocation(o, u);
			q.paint = function(r) {
				r.save();
				r.arc(0, 0, s, t, p);
				r.clip();
				r.beginPath();
				if (this.image != null) {
					r.drawImage(this.image, -this.width / 2, -this.height / 2)
				} else {
					r.fillStyle = "rgba(" + this.style.fillStyle + ","
							+ this.alpha + ")";
					r.rect(this.x, this.y, this.width, this.height);
					r.fill()
				}
				r.closePath();
				r.restore()
			};
			return q
		}
		var j = h;
		var k = h + Math.PI;
		var n = l(g.x, g.y, g.width, j, k);
		var m = l(g.x, g.y, g.width, j + Math.PI, j);
		return [ n, m ]
	}
	c.Animate.gravity = e;
	c.Animate.stepByStep = b;
	c.Effect.splitTwoPiece = d
})(JTopo);
