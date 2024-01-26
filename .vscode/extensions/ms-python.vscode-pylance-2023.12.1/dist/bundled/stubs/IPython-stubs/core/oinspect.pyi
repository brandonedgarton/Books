"""
This type stub file was generated by pyright.
"""

import sys
from dataclasses import dataclass
from typing import Any, Dict, Optional, Union
from typing_extensions import TypeAlias
from IPython.testing.skipdoctest import skip_doctest
from IPython.utils.coloransi import TermColors
from IPython.utils.colorable import Colorable
from IPython.utils.decorators import undoc

"""Tools for inspecting Python objects.

Uses syntax highlighting for presenting the various information elements.

Similar in spirit to the inspect module, but all calls take a name argument to
reference the name under which an object is being read.
"""
__all__ = ['Inspector', 'InspectColors']
if sys.version_info <= (3, 10):
    ...
else:
    ...
HOOK_NAME = ...
UnformattedBundle: TypeAlias = ...
Bundle: TypeAlias = ...
@dataclass
class OInfo:
    ismagic: bool
    isalias: bool
    found: bool
    namespace: Optional[str]
    parent: Any
    obj: Any
    def get(self, field):
        """Get a field from the object for backward compatibility with before 8.12

        see https://github.com/h5py/h5py/issues/2253
        """
        ...
    


def pylight(code): # -> None:
    ...

_func_call_docstring = ...
_object_init_docstring = ...
_builtin_type_docstrings = ...
_builtin_func_type = ...
_builtin_meth_type = ...
Colors = TermColors
InspectColors = ...
info_fields = ...
def object_info(**kw):
    """Make an object info dict with all fields present."""
    ...

def get_encoding(obj): # -> None:
    """Get encoding for python source file defining obj

    Returns None if obj is not defined in a sourcefile.
    """
    ...

def getdoc(obj) -> Union[str, None]:
    """Stable wrapper around inspect.getdoc.

    This can't crash because of attribute problems.

    It also attempts to call a getdoc() method on the given object.  This
    allows objects which provide their docstrings via non-standard mechanisms
    (like Pyro proxies) to still be inspected by ipython's ? system.
    """
    ...

def getsource(obj, oname=...) -> Union[str, None]:
    """Wrapper around inspect.getsource.

    This can be modified by other projects to provide customized source
    extraction.

    Parameters
    ----------
    obj : object
        an object whose source code we will attempt to extract
    oname : str
        (optional) a name under which the object is known

    Returns
    -------
    src : unicode or None

    """
    ...

def is_simple_callable(obj):
    """True if obj is a function ()"""
    ...

@undoc
def getargspec(obj):
    """Wrapper around :func:`inspect.getfullargspec`

    In addition to functions and methods, this can also handle objects with a
    ``__call__`` attribute.

    DEPRECATED: Deprecated since 7.10. Do not use, will be removed.
    """
    ...

@undoc
def format_argspec(argspec):
    """Format argspect, convenience wrapper around inspect's.

    This takes a dict instead of ordered arguments and calls
    inspect.format_argspec with the arguments in the necessary order.

    DEPRECATED (since 7.10): Do not use; will be removed in future versions.
    """
    ...

@undoc
def call_tip(oinfo, format_call=...):
    """DEPRECATED since 6.0. Extract call tip data from an oinfo dict."""
    ...

def find_file(obj) -> str:
    """Find the absolute path to the file where an object was defined.

    This is essentially a robust wrapper around `inspect.getabsfile`.

    Returns None if no file can be found.

    Parameters
    ----------
    obj : any Python object

    Returns
    -------
    fname : str
        The absolute path to the file where the object was defined.
    """
    ...

def find_source_lines(obj): # -> None:
    """Find the line number in a file where an object was defined.

    This is essentially a robust wrapper around `inspect.getsourcelines`.

    Returns None if no file can be found.

    Parameters
    ----------
    obj : any Python object

    Returns
    -------
    lineno : int
        The line number where the object definition starts.
    """
    ...

class Inspector(Colorable):
    def __init__(self, color_table=..., code_color_table=..., scheme=..., str_detail_level=..., parent=..., config=...) -> None:
        ...
    
    def set_active_scheme(self, scheme): # -> None:
        ...
    
    def noinfo(self, msg, oname): # -> None:
        """Generic message when no information is found."""
        ...
    
    def pdef(self, obj, oname=...): # -> None:
        """Print the call signature for any callable object.

        If the object is a class, print the constructor information."""
        ...
    
    @skip_doctest
    def pdoc(self, obj, oname=..., formatter=...): # -> None:
        """Print the docstring for any object.

        Optional:
        -formatter: a function to run the docstring through for specially
        formatted docstrings.

        Examples
        --------
        In [1]: class NoInit:
           ...:     pass

        In [2]: class NoDoc:
           ...:     def __init__(self):
           ...:         pass

        In [3]: %pdoc NoDoc
        No documentation found for NoDoc

        In [4]: %pdoc NoInit
        No documentation found for NoInit

        In [5]: obj = NoInit()

        In [6]: %pdoc obj
        No documentation found for obj

        In [5]: obj2 = NoDoc()

        In [6]: %pdoc obj2
        No documentation found for obj2
        """
        ...
    
    def psource(self, obj, oname=...): # -> None:
        """Print the source code for an object."""
        ...
    
    def pfile(self, obj, oname=...): # -> None:
        """Show the whole file where an object was defined."""
        ...
    
    def format_mime(self, bundle: UnformattedBundle) -> Bundle:
        """Format a mimebundle being created by _make_info_unformatted into a real mimebundle"""
        ...
    
    def pinfo(self, obj, oname=..., formatter=..., info: Optional[OInfo] = ..., detail_level=..., enable_html_pager=..., omit_sections=...): # -> None:
        """Show detailed information about an object.

        Optional arguments:

        - oname: name of the variable pointing to the object.

        - formatter: callable (optional)
              A special formatter for docstrings.

              The formatter is a callable that takes a string as an input
              and returns either a formatted string or a mime type bundle
              in the form of a dictionary.

              Although the support of custom formatter returning a string
              instead of a mime type bundle is deprecated.

        - info: a structure with some information fields which may have been
          precomputed already.

        - detail_level: if set to 1, more information is given.

        - omit_sections: set of section keys and titles to omit
        """
        ...
    
    def info(self, obj, oname=..., info=..., detail_level=...) -> Dict[str, Any]:
        """Compute a dict with detailed information about an object.

        Parameters
        ----------
        obj : any
            An object to find information about
        oname : str (default: '')
            Name of the variable pointing to `obj`.
        info : (default: None)
            A struct (dict like with attr access) with some information fields
            which may have been precomputed already.
        detail_level : int (default:0)
            If set to 1, more information is given.

        Returns
        -------
        An object info dict with known fields from `info_fields`. Keys are
        strings, values are string or None.
        """
        ...
    
    def psearch(self, pattern, ns_table, ns_search=..., ignore_case=..., show_all=..., *, list_types=...): # -> None:
        """Search namespaces with wildcards for objects.

        Arguments:

        - pattern: string containing shell-like wildcards to use in namespace
          searches and optionally a type specification to narrow the search to
          objects of that type.

        - ns_table: dict of name->namespaces for search.

        Optional arguments:

          - ns_search: list of namespace names to include in search.

          - ignore_case(False): make the search case-insensitive.

          - show_all(False): show all names, including those starting with
            underscores.

          - list_types(False): list all available object types for object matching.
        """
        ...
    


