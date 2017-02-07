SUMMARY = "xMZ-Mod-Touch-GUI systemd unit"
HOMEPAGE = "https://github.com/zzeroo/xMZ-Mod-Touch-GUI.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://xmz-mod-touch-gui.service"
PR = "r0"
S = "${WORKDIR}"

do_install() {
	install -Dm0644 ${WORKDIR}/xmz-mod-touch-gui.service ${D}${systemd_system_unitdir}/xmz-mod-touch-gui.service
}

inherit systemd

RDEPENDS_${PN} = "xmz-mod-touch-gui"

SYSTEMD_SERVICE_${PN} = "xmz-mod-touch-gui.service"
