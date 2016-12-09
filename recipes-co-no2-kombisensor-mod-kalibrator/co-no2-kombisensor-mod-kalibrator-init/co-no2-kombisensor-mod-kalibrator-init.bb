
SUMMARY = "CO-NO2-Kombisensor-Mod-Kalibrator Systemd Unit"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "file://kalibrator.service"

S = "${WORKDIR}"

do_install() {
	install -Dm0644 ${WORKDIR}/kalibrator.service ${D}${systemd_system_unitdir}/kalibrator.service
}

inherit systemd

RDEPENDS_${PN} = "co-no2-kombisensor-mod-kalibrator"

SYSTEMD_SERVICE_${PN} = "kalibrator.service"
