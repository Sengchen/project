var MinePlugin;
MinePlugin = {
		Html : {
			removeHTMLTag : function(str) {
				str = str.replace(/<\/?[^>]*>/g, ''); // 去除HTML tag
				str = str.replace(/[ | ]*\n/g, '\n'); // 去除行尾空白
				str = str.replace(/&nbsp;/ig, '');// 去掉&nbsp;
				str = str.replace(/\s/g, ''); // 将空格去掉
				return str;
			},

			removeBlankLine : function(str) {
				str = str.replace(/\n[\s| | ]*\r/g, '\n'); // 去除多余空行
			}

		},

		System : {
			judge : function {
				var sUserAgent = navigator.userAgent.toLowerCase();
				var isLinux = (String(navigator.platform).indexOf("linux") > -1);// 是否为linux内核
				var bIsAndroid = sUserAgent.match(/android/i) == "android";// 是否为安卓
				var bIsWP = sUserAgent.match(/windows\sphone/i) == "windows phone";// 是否为wp系统
				var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";// 是否为ipad
				var bIsIphoneOs = sUserAgent.match(/iphone\sos/i) == "iphone os";// 是否为ios
				var bIsCE = sUserAgent.match(/windows\snt/i) == "windows nt";// 是否为windows

				if (bIsCE) {
					return "pc";
				} else if (bIsWP) {
					return "wp";
				} else if (bIsAndroid) {
					return "android";
				} else if (isLinux) {
					return "linux";
				} else if (bIsIpad || bIsIphoneOs) {
					return "ios";
				}
			}
		}
}