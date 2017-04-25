SUMMARY = "xMZ-Mod-Touch-Server systemd unit"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://xmz-mod-touch-server.service"
PR = "r1"
S = "${WORKDIR}"

do_install() {
	install -Dm0644 ${WORKDIR}/xmz-mod-touch-server.service ${D}${systemd_system_unitdir}/xmz-mod-touch-server.service
}

inherit systemd

RDEPENDS_${PN} = "xmz-mod-touch-server"
RDEPENDS_${PN} = "xmz-mod-touch-server-configuration"

SYSTEMD_SERVICE_${PN} = "xmz-mod-touch-server.service"
