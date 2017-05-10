inherit cargo

SUMMARY = "Libmodbus Rust bindings"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \
  gitsm://github.com/zzeroo/libmodbus-rs.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

PR = "r0"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"


cargo_do_compile_prepend() {
  cargo test
}
