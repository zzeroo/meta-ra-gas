# DEPENDS = "clang"
DEPENDS = "gtk+3 libmodbus xmz-mod-touch-server-image"
RDEPENDS_${PN} = "xmz-mod-touch-server-configuration"
RDEPENDS_${PN} += "xmz-mod-touch-server-init"
