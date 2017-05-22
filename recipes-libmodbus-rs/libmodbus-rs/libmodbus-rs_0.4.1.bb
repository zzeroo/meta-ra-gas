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

PR = "r8"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "libmodbus"
RDEPENDS_${PN} += "libmodbus"

# # BUG: error: failed to run custom build command for `libloading v0.4.0`
# #   process didn't exit successfully: `/var/src/poky/build/tmp/work/armv7ahf-neon-vfpv4-poky-linux-gnueabi/libmodbus-rs/0.4.0-r1/target/release/build/libloading-34688c369e161e93/build-script-build` (exit code: 252) --- stderr
# #   Building for an unknown target_os=`Err(NotPresent)`!
# export CARGO_CFG_TARGET_OS = "linux"


do_install() {
  # disable do_install() task, because we only want to test the building.
  # A colon `:` stands for `true`.
  :
}
