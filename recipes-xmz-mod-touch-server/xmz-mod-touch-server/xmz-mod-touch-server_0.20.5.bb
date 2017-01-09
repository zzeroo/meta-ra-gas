inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=master;protocol=https"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"
PR = "r8"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"
RDEPENDS_${PN} += "gtk+3 libmodbus vim git curl"

cargo_do_compile_append() {
  cargo build --example configuration_to_json ${CARGO_BUILD_FLAGS}
  cargo build --example lampentest_led ${CARGO_BUILD_FLAGS}
  cargo build --example lampentest_relais ${CARGO_BUILD_FLAGS}
  cargo build --example lampentest_random_led ${CARGO_BUILD_FLAGS}
  cargo build --example lampentest_random_relais ${CARGO_BUILD_FLAGS}
}

do_install_append() {
  install -Dm 0755 ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/configuration_to_json ${D}/usr/local/bin/configuration_to_json
  install -Dm 0755 ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/lampentest_led ${D}/usr/local/bin/lampentest_led
  install -Dm 0755 ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/lampentest_relais ${D}/usr/local/bin/lampentest_relais
  install -Dm 0755 ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/lampentest_random_led ${D}/usr/local/bin/lampentest_random_led
  install -Dm 0755 ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/lampentest_random_relais ${D}/usr/local/bin/lampentest_random_relais
}

FILES_${PN} += " \
  /usr/local/bin/ \
  "
