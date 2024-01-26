from typing import Any, ClassVar

from ..cmd import Command

class install_egg_info(Command):
    description: ClassVar[str]
    user_options: ClassVar[list[tuple[str, str | None, str]]]
    install_dir: Any
    def initialize_options(self) -> None: ...
    target: Any
    outputs: Any
    def finalize_options(self) -> None: ...
    def run(self) -> None: ...
    def get_outputs(self) -> list[str]: ...

def safe_name(name): ...
def safe_version(version): ...
def to_filename(name): ...
