
SUMMARY = "xMZ-Mod-Touch-Server Configuration systemd unit"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://xmz-mod-touch-configuration.service"
PR = "r1"
S = "${WORKDIR}"

do_install() {
	install -Dm0644 ${WORKDIR}/xmz-mod-touch-configuration.service ${D}${systemd_system_unitdir}/xmz-mod-touch-configuration.service
}

inherit systemd

SYSTEMD_SERVICE_${PN} = "xmz-mod-touch-configuration.service"
