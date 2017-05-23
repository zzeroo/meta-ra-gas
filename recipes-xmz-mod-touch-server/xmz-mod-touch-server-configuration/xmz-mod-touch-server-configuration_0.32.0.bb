SUMMARY = "xMZ-Mod-Touch-Server Configuration systemd unit"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
	file://boot.mount \
	file://xmz-mod-touch-server-configuration.service \
"
PR = "r2"
S = "${WORKDIR}"
FILES_${PN} += "/lib/"

do_install_append() {
    install -Dm0644 ${WORKDIR}/boot.mount ${D}${systemd_system_unitdir}/boot.mount
		install -Dm0644 ${WORKDIR}/xmz-mod-touch-server-configuration.service ${D}${systemd_system_unitdir}/xmz-mod-touch-server-configuration.service
}

inherit systemd

SYSTEMD_SERVICE_${PN} = "xmz-mod-touch-server-configuration.service"
