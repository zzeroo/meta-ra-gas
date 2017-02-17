

SUMMARY = "Systemd Unit File für das Test Tool, der 'xMZ-Mod-Touch' Hardware"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-TestTool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://xmz-mod-touch-test-tool.service"
S = "${WORKDIR}"
PR = "r3"

do_install() {
	install -Dm0644 ${WORKDIR}/xmz-mod-touch-test-tool.service ${D}${systemd_system_unitdir}/xmz-mod-touch-test-tool.service
}

inherit systemd

RDEPENDS_${PN} = "xmz-mod-touch-test-tool"

SYSTEMD_SERVICE_${PN} = "xmz-mod-touch-test-tool.service"
