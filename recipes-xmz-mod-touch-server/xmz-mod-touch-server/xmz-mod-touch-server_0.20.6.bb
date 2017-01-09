inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=master;protocol=https"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"
PR = "r3"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"
RDEPENDS_${PN} += "gtk+3 libmodbus vim git curl"

cargo_do_compile_append() {
  for f in ${S}/examples/*.rs; do
    cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
  done
}

do_install_append() {
  for f in ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/*; do
    if [ -f "$f" ] && [ -x "$f" ]; then
      install -m 0755 "$f" "${D}${bindir}"
      bbnote "file installed: $f"
    fi
  done
}

FILES_${PN} += " \
  /usr/local/bin/ \
  "
