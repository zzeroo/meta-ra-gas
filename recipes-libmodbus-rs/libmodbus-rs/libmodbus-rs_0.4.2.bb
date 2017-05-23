inherit cargo

SUMMARY = "Libmodbus Rust bindings"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \
  gitsm://github.com/zzeroo/libmodbus-rs.git;branch=development;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PR = "r3"

PV = "1.0+git${SRCPV}"


# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "libmodbus"
RDEPENDS_${PN} += "libmodbus"

# Examples sollen auch alle mit in das Image eingebunden werden.
cargo_do_compile_append() {
  for f in ${S}/examples/*.rs; do
    cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
  done
}

# Install examples
do_install_append() {
  for f in ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/*; do
    if [ -f "$f" ] && [ -x "$f" ]; then
      install -m 0755 "$f" "${D}${bindir}"
      bbnote "file installed: $f"
    fi
  done
}
